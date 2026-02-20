package com.example.netisbackend.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
    basePackages = "com.example.netisbackend.mapper.transport",
    sqlSessionFactoryRef = "clickHouseSqlSessionFactory"
)
public class ClickHouseMyBatisConfig {

    @Bean
    public SqlSessionFactory clickHouseSqlSessionFactory(
            @Qualifier("clickHouseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/transport/*.xml")
        );
        factoryBean.setTypeAliasesPackage(
            "com.example.netisbackend.dto.transport," +
            "com.example.netisbackend.dto.transport.stats"
        );

        org.apache.ibatis.session.Configuration config =
            new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setCallSettersOnNulls(true);
        factoryBean.setConfiguration(config);

        return factoryBean.getObject();
    }
}
