package com.example.config;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
public class JpaConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.example.tracker.TrackerApplication");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(jpaProperties());
        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/issues");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789");
        return dataSource;
    }

    private Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        props.setProperty("hibernate.show_sql", "true");
        return props;
    }


}
