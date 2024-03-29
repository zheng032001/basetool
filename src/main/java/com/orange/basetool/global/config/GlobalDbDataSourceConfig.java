package com.orange.basetool.global.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * 主数据源，用于权限及本应用的数据操作
 */
@Configuration
@MapperScan(basePackages = "com.orange.basetool.global.mapper",sqlSessionTemplateRef = "primaryDbSqlSessionTemplate")
public class GlobalDbDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary-db")
    @Primary
    public DataSource primaryDbDataSource(){
        // SpringBoot原生方法
//        return DataSourceBuilder.create().build();
        // Druid 数据源
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public SqlSessionFactory primaryDbSqlSessionFactory(@Qualifier("primaryDbDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/global/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager primaryDbTransactionManager(@Qualifier("primaryDbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate primaryDbSqlSessionTemplate(@Qualifier("primaryDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
