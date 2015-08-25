package com.boredblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Non-MVC configuration.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.boredblog.controller",
        "com.boredblog.service"
})
public class RootConfig {
}
