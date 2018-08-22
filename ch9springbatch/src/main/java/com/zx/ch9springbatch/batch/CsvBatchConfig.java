package com.zx.ch9springbatch.batch;

import com.zx.ch9springbatch.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author ZhangXu
 * @date 2018/8/22 下午9:58
 */
//@Configuration
public class CsvBatchConfig {

    /**
     * 配置bean
     * 1。ItemReader
     * 2.ItemProcessor
     * 3.ItemWriter
     * 4.JobRepository
     * 5.JobLauncher
     * 6.Job
     * 7.Step
     * 8.JobListener
     * 9.Validator
     */

    @Bean
    public ItemReader<Person> reader(){
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("people.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>(){
            {
                setLineTokenizer(new DelimitedLineTokenizer(){
                    {
                        setNames("name", "age", "nation", "address");
                    }
                });

                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){
                    {
                        setTargetType(Person.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<Person,Person> processor(){
        CsvItemProcessor processor = new CsvItemProcessor();
        processor.setValidator(csvBeanValidator());
        return processor;
    }

    @Bean
    public ItemWriter<Person> writer(@Autowired DataSource dataSource){
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        //String sql = "insert into person (id,name,age,nation,address)"
        //        + "values(hibernate_sequence.nextval, :name, :age, :nation, :address)";
        String sql = "insert into person (name,age,nation,address)"
                + "values( :name, :age, :nation, :address)";
        writer.setSql(sql);
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public JobRepository jobRepository(DataSource dataSource,
                                       PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);

        System.err.println("jobRepository方法执行了。。。");

        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher simpleJobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();

        System.err.println("simpleJobLauncher方法执行了。。。");

        jobLauncher.setJobRepository(jobRepository(dataSource,transactionManager));

        System.err.println("simpleJobLauncher方法执行结束了。。。");

        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobBuilderFactory, Step step){
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .listener(csvJobListener())
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader,
                     ItemWriter<Person> writer, ItemProcessor<Person,Person> processor) {
        return stepBuilderFactory.get("step1")
                .<Person,Person>chunk(65000)
                .reader(reader)
                .writer(writer)
                .processor(processor)
                .build();
    }

    @Bean
    public JobExecutionListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<? super Person> csvBeanValidator() {
        return new CsvBeanValidator<>();
    }

}
