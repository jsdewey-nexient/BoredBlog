package com.boredblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Configures the Spring application as a MVC application.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.boredblog.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
}
