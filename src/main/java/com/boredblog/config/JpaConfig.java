package com.boredblog.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

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
    @Value("${database.driverClassName}")
    private String driverClassName;
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.showSql}")
    private Boolean showSql;
    @Value("${database.jdbc.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${database.jdbc.minPoolSize}")
    private Integer minPoolSize;
    @Value("${database.jdbc.maxStatements}")
    private Integer maxStatements;
    @Value("${database.jdbc.testConnection}")
    private Boolean testConnection;
    private Boolean ddl = false;
    private static final String ENTITIES_PACKAGE = "com.boredblog.entity";

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.driverClassName);
        dataSource.setJdbcUrl(this.url);
        dataSource.setUser(this.username);
        dataSource.setPassword(this.password);
        dataSource.setMinPoolSize(this.minPoolSize);
        dataSource.setMaxPoolSize(this.maxPoolSize);
        dataSource.setMaxStatements(this.maxStatements);
        dataSource.setTestConnectionOnCheckout(this.testConnection);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
            throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(this.dataSource());
        emfb.setJpaVendorAdapter(this.jpaVendorAdapter());
        emfb.setPackagesToScan(ENTITIES_PACKAGE);

        return emfb;
    }

    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(this.showSql);
        adapter.setGenerateDdl(this.ddl);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");

        return adapter;
    }
}
