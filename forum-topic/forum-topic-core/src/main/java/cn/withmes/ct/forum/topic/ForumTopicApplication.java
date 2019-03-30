package cn.withmes.ct.forum.topic;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.topic.mapper")
@EnableDubbo(scanBasePackages = "cn.withmes.ct.forum.topic.service")
public class ForumTopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumTopicApplication.class, args);
    }

}
