package com.example.netisbackend.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.netisbackend.repository.oracle",
        entityManagerFactoryRef = "oracleEntityManagerFactory",
        transactionManagerRef = "oracleTransactionManager"
)
public class OracleDataSourceConfig {

    @Bean
    @ConfigurationProperties("oracle.datasource")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oracleDataSource() {
        return oracleDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(oracleDataSource())
                .packages("com.example.netisbackend.entity.oracle")
                .persistenceUnit("oracle")
                .properties(Map.of(
                        "hibernate.dialect", "org.hibernate.dialect.OracleDialect",
                        "hibernate.hbm2ddl.auto", "none",
                        "hibernate.show_sql", "true",
                        "hibernate.format_sql", "true"
                ))
                .build();
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager(
            LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory) {
        return new JpaTransactionManager(oracleEntityManagerFactory.getObject());
    }
}
