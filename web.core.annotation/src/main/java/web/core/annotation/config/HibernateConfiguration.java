package web.core.annotation.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("unused")
@Configuration
@EnableTransactionManagement
@ComponentScan({"web.core.annotation.config"})
@PropertySource(value= {"classpath:config.properties"})
public class HibernateConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws Exception {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan("web.core.annotation.entity");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.afterPropertiesSet();
		SessionFactory sf = factoryBean.getObject();
		return factoryBean;
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUrl(environment.getProperty("jdbcURL"));
		dataSource.setUsername(environment.getProperty("jdbcUsername"));
		dataSource.setPassword(environment.getProperty("jdbcPassword"));
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("c3p0.min_size", environment.getRequiredProperty("c3p0.min_size"));
		properties.put("c3p0.max_size", environment.getRequiredProperty("c3p0.max_size"));
		properties.put("c3p0.timeout", environment.getRequiredProperty("c3p0.timeout"));
		properties.put("c3p0.max_statements", environment.getRequiredProperty("c3p0.max_statements"));
		properties.put("c3p0.idle_test_period", environment.getRequiredProperty("c3p0.idle_test_period"));
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
}
