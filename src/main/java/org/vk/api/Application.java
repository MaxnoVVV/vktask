package org.vk.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vk.api.config.ApplicationConfig;

@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        var ctx = SpringApplication.run(Application.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}
