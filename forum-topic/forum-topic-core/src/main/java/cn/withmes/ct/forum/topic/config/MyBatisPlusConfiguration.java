/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月19日
 */

package cn.withmes.ct.forum.topic.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * ClassName: MyBatisPlusConfiguration
 * @Description:配置Mybatis-plus
 * @param:
 *  #Configuration
 *  #EnableTransactionManagement 分页插件
 * @author leegoo
 * @date 2019年03月19日
 */
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfiguration {

    /**
     * @Description:逻辑删除
     * @param:
     * @return:
     * @auther: liming
     * @date: 2019/3/20 15:49
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}

