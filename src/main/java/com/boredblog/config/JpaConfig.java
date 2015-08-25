package com.boredblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Joel Dewey
 * @date 8/25/2015
 * Group: Joel
 * Configures the application to use Hibernate + JPA.
 */
@Configuration
@EnableJpaRepositories("com.boredblog.repository")
@EnableTransactionManagement
public class JpaConfig {
}
