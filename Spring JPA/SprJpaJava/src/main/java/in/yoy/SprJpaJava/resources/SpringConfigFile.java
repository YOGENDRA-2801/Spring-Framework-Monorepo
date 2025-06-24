package in.yoy.SprJpaJava.resources;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.yoy.SprJpaJava.entity.Department;

@EnableTransactionManagement
@ComponentScan ( basePackages = {"in.yoy.SprJpaJava"} )
public class SpringConfigFile {
	
	@Bean
	public DataSource dMDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ; // DMDS ka hi ref rkhna as DS me required methods nahi hai
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_jpa");
		dataSource.setUsername("root") ;
		dataSource.setPassword("ABCxyz123@") ;
		return dataSource ;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager () {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean() ;
		lcemfb.setDataSource(dMDataSource());
		lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter()) ;
		lcemfb.setPackagesToScan("in.yoy.SprJpaJava.entity");
		
		Properties prop = new Properties() ;
		prop.setProperty("hibernate.hbm2ddl.auto", "update") ;
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect") ;
		prop.setProperty("hibernate.show_sql", "true") ;
		prop.setProperty("hibernate.format_sql", "true") ;
		
		lcemfb.setJpaProperties(prop);
//		lcemfb.setJpaProperties(hibernateProperties());
		return lcemfb ;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() { 
		JpaTransactionManager jtm = new JpaTransactionManager() ;
		jtm.setEntityManagerFactory(entityManager().getObject());
		return jtm ;
	}
	
	@Bean
	public Department dept() { 
		Department dept = new Department("Quality", 8, "Satish") ;
		return dept ;
	}
	
//	public Properties hibernateProperties()
//	{
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		hibernateProperties.setProperty("hibernate.show_sql", "true");
//		hibernateProperties.setProperty("hibernate.format_sql", "true") ;
//		return hibernateProperties;
//	}

}