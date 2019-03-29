package cn.withmes.ct.forum.topic;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages={"cn.withmes.ct.forum.topic"})
@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.topic.mapper")
@EnableDubbo(scanBasePackages = "cn.withmes.ct.forum.topic.service")
public class ForumTopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumTopicApplication.class, args);
    }

    @RestController
    @RefreshScope
    class EchoController {

      /*  @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public String hello() {
            System.out.println(demoService);
            return "i am " + demoService.sayName("") + ".....";
        }*/


    }


}
