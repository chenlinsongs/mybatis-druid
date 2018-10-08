package com.thorough.mybatis;

import com.thorough.mybatis.dao.Image;
import com.thorough.mybatis.dao.ImageDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MybatisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MybatisApplication.class, args);
		ImageDao imageDao = context.getBean(ImageDao.class);
		Image image = imageDao.selectByPrimaryKey("1");
		String s = (String) context.getBean("stringTest");
		System.out.println(s.toString());
	}
}
