package com.example.netisbackend.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
    basePackages = "com.example.netisbackend.mapper",
    sqlSessionFactoryRef = "mybatisSqlSessionFactory"
)
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory mybatisSqlSessionFactory(
            @Qualifier("postgresDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/**/*.xml")
        );
        factoryBean.setTypeAliasesPackage("com.example.netisbackend.dto.menu");

        org.apache.ibatis.session.Configuration config =
            new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setCallSettersOnNulls(true);
        factoryBean.setConfiguration(config);

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate mybatisSqlSessionTemplate(
            @Qualifier("mybatisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
