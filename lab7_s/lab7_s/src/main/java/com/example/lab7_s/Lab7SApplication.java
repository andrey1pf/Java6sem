package com.example.lab7_s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MvcConfig.class)
public class Lab7SApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab7SApplication.class, args);
    }

}
