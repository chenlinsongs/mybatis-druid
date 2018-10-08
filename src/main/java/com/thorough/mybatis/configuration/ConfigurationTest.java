package com.thorough.mybatis.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "jdbc",name = "testSql",matchIfMissing=true)
@EnableConfigurationProperties(DataSourceProperties.class)
public class ConfigurationTest {

    private final DataSourceProperties dataSourceProperties;

    public ConfigurationTest(DataSourceProperties dataSourceProperties1){

        this.dataSourceProperties = dataSourceProperties1;
    }

    @Bean(name = "stringTest")
    public String getString(){
        System.out.println("hello configuration!");
        return new String(dataSourceProperties.getDriver());
    }
}
