package com.alibaba.api2doc.config;

import com.taobao.tddl.client.jdbc.TDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.alibaba.api2doc.dao2", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceConfig2 {
    @Bean(name = "test2DataSource")
    public DataSource getDateSource2(Environment env) {
        DataSource dataSource = DataSourceBuilder.create()
                .url(env.getProperty("datasource.second.url"))
                .type(TDataSource.class)
                .build();
        return dataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:com/alibaba/api2doc/mapper2/*.xml"));
        return bean.getObject();
    }

    @Bean("test2SqlSessionTemplate")
    public SqlSessionTemplate test2sqlsessiontemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
