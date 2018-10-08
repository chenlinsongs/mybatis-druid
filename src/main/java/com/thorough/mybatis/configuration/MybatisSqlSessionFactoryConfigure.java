package com.thorough.mybatis.configuration;

import com.thorough.mybatis.persistence.model.entity.Entity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisSqlSessionFactoryConfigure {

    @Autowired
    DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(){
        SqlSessionFactoryBean bean = new DynamicMapperSqlSessionBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com");
        bean.setTypeAliasesSuperType(Entity.class);
        //添加XML目录
        ResourcePatternResolver configResolver = new PathMatchingResourcePatternResolver();
        ResourcePatternResolver mapperResolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setConfigLocation(configResolver.getResource("classpath:/mybatis-config.xml"));
//            bean.setMapperLocations(mapperResolver.getResources("classpath:/mappings/modules/**/*.xml"));
            bean.setMapperLocations(null);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
