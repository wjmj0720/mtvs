package com.ohgiraffers.chap07thymeleaf.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.ohgiraffers.chap07thymeleaf"
)
public class Chap07ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap07ThymeleafApplication.class, args);
    }


}
