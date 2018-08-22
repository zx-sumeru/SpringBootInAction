package com.zx.ch9springbatch.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;


/**
 * @author ZhangXu
 * @date 2018/8/22 下午9:47
 */
public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                stringBuilder.append(constraintViolation.getMessage() + "\n");
            }
            //有数据校验不通过则在此抛出异常，包含校验信息
            throw new ValidationException(stringBuilder.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}
