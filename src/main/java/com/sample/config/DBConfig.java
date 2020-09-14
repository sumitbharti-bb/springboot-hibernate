package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {
		"com.sample.dao" })
public class DBConfig {

	private ApplicationConfig applicationConfig;

	@Autowired
	public DBConfig(ApplicationConfig applicationConfig) {
		this.applicationConfig = applicationConfig;
	}

	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return new RdsHikariDataSource(applicationConfig.getJdbcUrl(), applicationConfig.getUserName(),
				applicationConfig.getPassword());
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabase(Database.MYSQL);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "none");
		factoryBean.setJpaProperties(jpaProperties);

		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(new String[] { "com.sample.entity" });
		return factoryBean;
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
