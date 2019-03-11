package com.orange.basetool.datasource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.orange.basetool.mapper.test",sqlSessionTemplateRef = "testDbSqlSessionTemplate")
public class TestDbDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test-db")
    public DataSource testDbDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory testDbSqlSessionFactory(@Qualifier("testDbDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/test/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager testDbTransactionManager(@Qualifier("testDbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate testDbSqlSessionTemplate(@Qualifier("testDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
