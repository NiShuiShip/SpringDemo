package com.zxy.config;

import com.zxy.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * spring中可以知道加了@Configuration注解的类，会被进行cglib的代理增强，
 * 类中的方法被调用的时候，当已经存在该对象，会直接返回该对象，不存在的时候才会调用方法的正常逻辑产生对象.
 */
@Configuration
@ComponentScan("com.zxy")
@MapperScan("com.zxy.dao")
public class ApplicationConfig {

    @Bean
    public DataSource dataSource() {
        System.err.println("dataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.19.3:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");
        return dataSource;
    }

    /**
     * 按照我的理解，SqlSessionFactoryBean实现了FactoryBean接口，可以在getObject()方法中实例化一个名为sqlSessionFactoryBean的bean并返回
     * 同时产生一个名为$sqlSessionFactoryBean的bean。
     * 但是在这里面，很明显的，并没有进行bean的生成，只是返回了一个sqlSessionFactory的对象，然后通过@Bean的注解，来实现Bean的初始化过程
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }


}
