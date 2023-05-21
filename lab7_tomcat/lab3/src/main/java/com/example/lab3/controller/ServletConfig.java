package com.example.lab3.controller;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<ExampleServlet> exampleServletRegistrationBean() {
        ServletRegistrationBean<ExampleServlet> registrationBean = new ServletRegistrationBean<>(new ExampleServlet());
        registrationBean.setUrlMappings(Arrays.asList("/example"));
        return registrationBean;
    }

}
