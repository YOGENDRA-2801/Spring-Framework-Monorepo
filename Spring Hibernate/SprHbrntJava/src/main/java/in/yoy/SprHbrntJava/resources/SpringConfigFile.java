package in.yoy.SprHbrntJava.resources;

import java.math.BigDecimal;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.yoy.SprHbrntJava.beans.Students;
import in.yoy.SprHbrntJava.dao.StudDaoImplmt;
import in.yoy.SprHbrntJava.service.StudSrvcImplmt;

@EnableTransactionManagement
public class SpringConfigFile {
//	1. CREATE A BEAN FOR DATASOURCE
	@Bean
	public DataSource dMDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource() ;
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://127.0.0.1:3306/spr_hbrnt");
		dmds.setUsername("root") ;
		dmds.setPassword("ABCxyz123@") ;
		return dmds ;
	}
//	2. CREATE BEAN FOR SESSION FACTORY
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean() ;
		lsfb.setDataSource(dMDataSource());
		Properties properties = new Properties() ;
		properties.setProperty("hibernate.hbm2ddl.auto", "update") ;
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect") ;
		properties.setProperty("hibernate.show_sql", "true") ;
		properties.setProperty("hibernate.formate_sql", "true") ;
		lsfb.setHibernateProperties(properties);
		lsfb.setPackagesToScan("in.yoy.SprHbrntJava.beans");
		return lsfb ;
	}
//	3. ENABLE TRANSACTION MANAGEMENT -- ALREADY DONE AT FIRST
//	4. CREATE A BEAN FOR TRASACTION MANAGER
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm ;
	}
//	5. CREATE A BEAN FOR HIBERNATE TEMPLATE
	@Bean
	public HibernateTemplate hbTemp() {
		HibernateTemplate ht = new HibernateTemplate() ;
		ht.setSessionFactory(sessionFactory().getObject());
		return ht ;
	}
//	DAO BEAN
	@Bean
	public StudDaoImplmt studDaoImp() {
		StudDaoImplmt sdi = new StudDaoImplmt() ;
		sdi.setHbTemp(hbTemp());
		return sdi;
	}
//	SERVICE BEAN
	@Bean
	public StudSrvcImplmt studDaoService() {
		StudSrvcImplmt ssi = new StudSrvcImplmt() ;
		ssi.setStudDao(studDaoImp());
		return ssi ;
	}
//	STUDENT BEAN
	@Bean
	public Students stud() {
		Students std = new Students("Satish", "BSC-CS", new BigDecimal(111.11)) ;
		return std ;
	}
}
