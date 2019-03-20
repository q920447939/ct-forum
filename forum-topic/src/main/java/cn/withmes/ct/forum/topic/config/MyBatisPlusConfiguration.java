/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月19日
 */

package cn.withmes.ct.forum.topic.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ClassName: MyBatisPlusConfiguration
 * @Description:
 * @author leegoo
 * @date 2019年03月19日
 */

@Configuration
public class MyBatisPlusConfiguration {

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}

