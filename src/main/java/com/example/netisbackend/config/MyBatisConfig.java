package com.example.netisbackend.config;

import com.example.netisbackend.mapper.MenuMapper;
import com.example.netisbackend.mapper.MenuMgmtMapper;
import com.example.netisbackend.mapper.widget.WidgetMapper;
import com.example.netisbackend.mapper.userconf.UserConfMapper;
import com.example.netisbackend.mapper.topology.D3TopoMapper;
import com.example.netisbackend.mapper.topology.GisTopoMapper;
import com.example.netisbackend.mapper.topology.RackTopoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@MapperScan(
    basePackageClasses = {MenuMapper.class, MenuMgmtMapper.class, WidgetMapper.class, UserConfMapper.class,
        D3TopoMapper.class, GisTopoMapper.class, RackTopoMapper.class},
    sqlSessionFactoryRef = "mybatisSqlSessionFactory"
)
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory mybatisSqlSessionFactory(
            @Qualifier("postgresDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = new ArrayList<>();
        resources.addAll(Arrays.asList(resolver.getResources("classpath:mapper/menu/*.xml")));
        resources.addAll(Arrays.asList(resolver.getResources("classpath:mapper/widget/*.xml")));
        resources.addAll(Arrays.asList(resolver.getResources("classpath:mapper/userconf/*.xml")));
        resources.addAll(Arrays.asList(resolver.getResources("classpath:mapper/topology/*.xml")));
        factoryBean.setMapperLocations(resources.toArray(new Resource[0]));
        factoryBean.setTypeAliasesPackage(
            "com.example.netisbackend.dto.menu," +
            "com.example.netisbackend.dto.widget," +
            "com.example.netisbackend.dto.userconf," +
            "com.example.netisbackend.dto.topology"
        );

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
