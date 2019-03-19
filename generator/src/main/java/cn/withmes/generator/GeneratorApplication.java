package cn.withmes.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApplication {

    @Deprecated
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }

}
