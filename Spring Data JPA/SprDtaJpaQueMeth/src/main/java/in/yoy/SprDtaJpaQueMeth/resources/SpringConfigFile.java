package in.yoy.SprDtaJpaQueMeth.resources;

import java.math.BigDecimal;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.yoy.SprDtaJpaQueMeth.entity.Employee;

@EnableJpaRepositories (basePackages = { "in.yoy.SprDtaJpaQueMeth.repository" } )
@EnableTransactionManagement
@ComponentScan ( basePackages = { "in.yoy.SprDtaJpaQueMeth" } )
@Configuration
public class SpringConfigFile {
	@Bean
	public DataSource dMDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ; // DMDS ka hi ref rkhna as DS me required methods nahi hai
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_data_jpa");
		dataSource.setUsername("root") ;
		dataSource.setPassword("ABCxyz123@") ;
		return dataSource ;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory () {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean() ;
		lcemfb.setDataSource(dMDataSource());
		lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter()) ;
		lcemfb.setPackagesToScan("in.yoy.SprDtaJpaQueMeth.entity");
		
		Properties prop = new Properties() ;
		prop.setProperty("hibernate.hbm2ddl.auto", "update") ;
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect") ;
		prop.setProperty("hibernate.show_sql", "true") ;
		prop.setProperty("hibernate.format_sql", "true") ;
		
		lcemfb.setJpaProperties(prop);
		return lcemfb ;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() { 
		JpaTransactionManager jtm = new JpaTransactionManager() ;
		jtm.setEntityManagerFactory(entityManagerFactory().getObject());
		return jtm ;
	}
	
	@Bean
	public Employee employee() {
		Employee emp = new Employee("Satish", "DevOps", new BigDecimal(12345.67)) ;
		return emp ;
	}
}