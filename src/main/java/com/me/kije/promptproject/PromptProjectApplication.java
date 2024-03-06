package com.me.kije.promptproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PromptProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromptProjectApplication.class, args);
    }

}
