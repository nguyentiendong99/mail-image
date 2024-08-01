package com.example.emailtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication
public class EmailTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailTemplateApplication.class, args);
    }

}
