/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月03日
 */
package cn.withmes.forum.api.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * ClassName: ValidatorCnf
 * @Description:
 * @author leegoo
 * @date 2019年04月03日
 */
public class ValidatorCnf {

    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }


}
