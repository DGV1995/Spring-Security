package com.diegogv95.securitydemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.diegogv95.securitydemo")
public class AppConfiguration {
    // Define a bean for ViewResolver
    //@Bean
    /*public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // Prefix and suffix of the file where the controllers templates will be located
        viewResolver.setPrefix("/WEB_INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver
    }
}*/

