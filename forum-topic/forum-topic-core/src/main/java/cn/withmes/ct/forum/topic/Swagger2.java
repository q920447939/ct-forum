/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月20日
 */
package cn.withmes.ct.forum.topic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName: Swagger2
 * @Description:
 * @author leegoo
 * @date 2019年03月20日
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.withmes.ct.forum.topic"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("forum-topic API")
                .description("此页面会标记出所有的后台API接口以及参数")
                .termsOfServiceUrl("")
                .contact("leegoo")
                .version("1.0")
                .build();
    }
}