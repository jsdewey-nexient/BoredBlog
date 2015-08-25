package com.boredblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Joel Dewey
 * @date 8/25/2015
 * Group: Joel
 * Imports properties from external files.
 */
@Configuration
@PropertySource({ "classpath:db.database.properties" })
public class PropertyPlaceholderConfig {

}
