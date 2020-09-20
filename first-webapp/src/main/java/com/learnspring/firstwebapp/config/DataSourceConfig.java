package com.learnspring.firstwebapp.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.learnspring.firstwebapp.repository")
public class DataSourceConfig {
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String DB_DRIVER = "org.postgresql.Driver";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "password";
  private static final String DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";
  private static final int MAX_FETCH_DEPTH = 3;
  private static final int FETCH_SIZE = 50;
  private static final int BATCH_SIZE = 10;
  private static final boolean IS_LOGGING = true;
  private static final String DDL_PARAM = "validate";
  
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean getEntityManager() {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(getDataSource());
    factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    factory.setPackagesToScan("com.learnspring.firstwebapp.domain");
    factory.setJpaProperties(getJpaProperties());
    return factory;
  }
  
  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(DB_URL);
    dataSource.setDriverClassName(DB_DRIVER);
    dataSource.setUsername(USERNAME);
    dataSource.setPassword(PASSWORD);
    return dataSource;
  }
  
  @Bean(name = "jpaProperties")
  public Properties getJpaProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.dialect", DIALECT);
    jpaProperties.put("hibernate.max_fetch_depth", MAX_FETCH_DEPTH);
    jpaProperties.put("hibernate.jdbc.fetch_size", FETCH_SIZE);
    jpaProperties.put("hibernate.jdbc.batch_size", BATCH_SIZE);
    jpaProperties.put("hibernate.show_sql", IS_LOGGING);
    jpaProperties.put("hibernate.hbm2ddl.auto", DDL_PARAM);  
    return jpaProperties;
  }
  
  @Bean(name = "transactionManager")
  public JpaTransactionManager transactionManager(EntityManagerFactory  entityManagerFactory) {        
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(entityManagerFactory);
    return tm;
  }
  
}
