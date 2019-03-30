package cn.withmes.ct.forum.member.core;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.withmes.ct.forum.member.core.mapper")
@EnableDubbo(scanBasePackages = "cn.withmes.ct.forum.member.core.service.impl")
public class ForumMemberCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumMemberCoreApplication.class, args);
    }

}
