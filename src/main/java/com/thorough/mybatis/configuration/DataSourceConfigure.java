package com.thorough.mybatis.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ConditionalOnProperty(prefix = "jdbc",name = "testSql",matchIfMissing=true)
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfigure {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfigure(DataSourceProperties dataSourceProperties1){

        this.dataSourceProperties = dataSourceProperties1;
    }

    @Bean(name="dataSource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dataSourceProperties.getDriver());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setInitialSize(dataSourceProperties.getInitialSize());
        druidDataSource.setMinIdle(dataSourceProperties.getMinIdle());
        druidDataSource.setMaxActive(dataSourceProperties.getMaxActive());
        druidDataSource.setMaxWait(dataSourceProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dataSourceProperties.getTestSql());
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
