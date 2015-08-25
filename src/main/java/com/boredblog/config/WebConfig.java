package com.boredblog.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Configures the Spring application as a MVC application.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.boredblog.controller",
        "com.boredblog.entity",
        "com.boredblog.manager"
})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(
            final List<HttpMessageConverter<?>> converters) {
        converters.add(this.jackson2HttpMessageConverter());
    }

    // This must be a bean so tests can access it.
    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        final MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter();
        final Jackson2ObjectMapperBuilder builder = this.jacksonBuilder();
        converter.setObjectMapper(builder.build());
        return converter;
    }

    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        final Jackson2ObjectMapperBuilder builder =
                new Jackson2ObjectMapperBuilder();
        builder.propertyNamingStrategy(
                PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        return builder;
    }
}
