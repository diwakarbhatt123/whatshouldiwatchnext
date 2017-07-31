package com.whatshouldiwatchnext.init;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.hibernate.cfg.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by diwakar on 09/07/17.
 */
@Configuration
public class Init {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalSessionFactoryBean  sessionFactory() throws ClassNotFoundException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setConfigLocation(new FileSystemResource(getClass().getClassLoader().getResource("hibernate.cfg.xml").getPath()));
        return localSessionFactoryBean;
    }

}
