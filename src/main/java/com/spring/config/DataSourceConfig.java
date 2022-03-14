package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 12:25
 **/
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String passWord;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.driver}")
    private String driverClass;

    @Bean
    DataSource getC3p0DataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(this.user);
        comboPooledDataSource.setPassword(this.passWord);
        comboPooledDataSource.setJdbcUrl(this.jdbcUrl);
        comboPooledDataSource.setDriverClass(this.driverClass);
        return comboPooledDataSource;
    }
}
