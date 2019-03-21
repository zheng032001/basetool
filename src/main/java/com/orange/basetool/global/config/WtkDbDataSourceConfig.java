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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.orange.basetool.wtk.mapper",sqlSessionTemplateRef = "wtkDbSqlSessionTemplate")
public class WtkDbDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.wtk-db")
    public DataSource wtkDbDataSource(){
        // SpringBoot原生方法
//        return DataSourceBuilder.create().build();
        // Druid 数据源
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory wtkDbSqlSessionFactory(@Qualifier("wtkDbDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/wtk/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager wtkDbTransactionManager(@Qualifier("wtkDbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate wtkDbSqlSessionTemplate(@Qualifier("wtkDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
