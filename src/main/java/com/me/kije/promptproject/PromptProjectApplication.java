package com.me.kije.promptproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import jisay.library.model.Func;
import jisay.library.module.CrudAuto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})


public class PromptProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(PromptProjectApplication.class, args);
    }
}
