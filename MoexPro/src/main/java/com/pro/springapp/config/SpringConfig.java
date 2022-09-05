package com.pro.springapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.pro.springapp")
@PropertySource("classpath:app.properties")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

}
