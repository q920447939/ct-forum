package cn.withmes.ct.forum.topic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.topic.mapper")
public class ForumTopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumTopicApplication.class, args);
    }

    @RestController
    @RefreshScope
    class EchoController {
        @Value("${name}")
        private String name;
        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string+"\r test: i am :"+name;
        }
    }


}
