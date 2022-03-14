package com.spring.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 13:44
 **/
@Configuration
@Import({DataSourceConfig.class,MyWebConfig.class})
public class SqlSessionFactoryConfig {

    /**
     * 配置sqlSessionFactory
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean("sqlSessionFactory")
    SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resource = pathMatchingResourcePatternResolver.getResources("classpath:mapper/**.xml");
        sqlSessionFactoryBean.setMapperLocations(resource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.spring.model");
        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper扫描的路径
     * @return
     */
    @Bean
    MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.spring.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
