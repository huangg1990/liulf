package com.liulf.config.datasource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "liulfDataSource")
    @Qualifier("liulfDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.liulf")
    public DataSource liulfDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "liulfJdbcTemplate")
    public JdbcTemplate liulfJdbcTemplate(@Qualifier("liulfDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
