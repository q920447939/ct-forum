package cn.withmes.ct.forum.topic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.topic.mapper")
public class ForumTopicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumTopicApplication.class, args);
    }



}
