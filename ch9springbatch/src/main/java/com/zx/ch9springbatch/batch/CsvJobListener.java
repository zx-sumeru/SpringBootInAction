package com.zx.ch9springbatch.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author ZhangXu
 * @date 2018/8/22 下午9:55
 */
public class CsvJobListener implements JobExecutionListener {

    long startTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("mission start ...");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("mission end ...");
        System.out.println("cost time : " + (endTime - startTime) + "ms");
    }
}
