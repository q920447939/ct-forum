package cn.withmes.ct.forum.topic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.topic.mapper")
public class ForumTopicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumTopicApplication.class, args);
    }


}
