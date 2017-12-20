package ru.goodnews.hot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories("ru.goodnews.hot.repository")
@EnableTransactionManagement
@PropertySource(value = { "classpath:database.properties" })
public class DatabaseConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        ds.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
        ds.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        ds.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        return ds;
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException{

        JpaTransactionManager jpaTransaction = new JpaTransactionManager();
        jpaTransaction.setEntityManagerFactory(emf);
        jpaTransaction.setDataSource(dataSource());

        return jpaTransaction;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("ru.goodnews.hot.model");

        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.hibernate.dialect"));
        jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("spring.jpa.hibernate.format_sql"));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
}
