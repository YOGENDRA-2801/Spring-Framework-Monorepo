package in.yoy.SprJdbcDao.UsingAnnotation;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"in.yoy.SprJdbcDao.UsingAnnotation"})
public class SpringConfigFile 
{
	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_jdbc");
		driverManagerDataSource.setUsername("root") ;
		driverManagerDataSource.setPassword("ABCxyz123@") ;
		return driverManagerDataSource ;
	}
	
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate() ;
		jdbcTemplate.setDataSource(createDataSource());
		return jdbcTemplate ;
	}
	
	@Bean
	public StockBean itemBean() {
		StockBean item = new StockBean(4, "Hoodie", new BigDecimal(543.21)) ;
		return item ;
	}
	
}
