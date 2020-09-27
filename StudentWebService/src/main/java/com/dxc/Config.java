package com.dxc;

import java.util.Properties;  
import javax.sql.DataSource;  
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;  
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.ComponentScans;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.jdbc.datasource.DriverManagerDataSource;  
import org.springframework.orm.hibernate5.HibernateTransactionManager;  
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;  
import org.springframework.transaction.annotation.EnableTransactionManagement;  
import org.springframework.web.servlet.view.InternalResourceViewResolver;  
  
  
@Configuration  
@EnableTransactionManagement  
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class})  
@ComponentScans(value = { @ComponentScan("boot.entry"),  
          @ComponentScan("com.dxc.model"),  
          @ComponentScan("com.dxc.controller"),  
          @ComponentScan("com.dxc.dao"),  
          @ComponentScan("com.dxc"),  
          @ComponentScan("com.dxc.service")})  
public class Config {  
  
  
        @Bean  
        public LocalSessionFactoryBean sessionFactory() {  
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
            sessionFactory.setDataSource(dataSource());    
            Properties hibernateProperties = new Properties();   
            sessionFactory.setHibernateProperties(hibernateProperties);  
            return sessionFactory;  
        }  
  
        @Bean  
        public DataSource dataSource() {  
            DriverManagerDataSource dataSource = new DriverManagerDataSource();  
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");  
            dataSource.setUrl("jdbc:mysql://localhost:3306/dxc1");  
            dataSource.setUsername("root");  
            dataSource.setPassword("root");  
            return dataSource;  
        }  
  
        @Bean  
        public HibernateTransactionManager transactionManager() {  
            HibernateTransactionManager txManager = new HibernateTransactionManager();  
            txManager.setSessionFactory(sessionFactory().getObject());  
            return txManager;  
        }  
          
        @Bean  
        public InternalResourceViewResolver jspViewResolver() {  
            InternalResourceViewResolver resolver= new InternalResourceViewResolver();  
            resolver.setPrefix("/views/");  
            resolver.setSuffix(".jsp");  
            return resolver;  
        }   
         
         
         
    }  