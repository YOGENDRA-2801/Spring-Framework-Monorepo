package in.yoy.SprJdbcBatch.resources;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.yoy.SprJdbcBatch.beans.Items;

@Configuration
public class SpringConfigFile 
{
	@Bean
	public DataSource createDataSource() 
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource() ;
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_jdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("ABCxyz123@");
		return driverManagerDataSource ;
	}
	
	@Bean("JdbcTemplate")
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jTemplate = new JdbcTemplate() ;
		jTemplate.setDataSource(createDataSource());
		return jTemplate ;
	}
	
	@Bean("firstItem")
	public Items creatItem1() {
		Items item = new Items(101 , "Shirt" , new BigDecimal(449.49)) ;
		return item ;
	}
	
	@Bean("secondItem")
	public Items creatItem2() {
		Items item = new Items(102 , "Kurta" , new BigDecimal(777.77)) ;
		return item ;
	}
	
	@Bean("thirdItem")
	public Items creatItem3() {
		Items item = new Items(103 , "Suits" , new BigDecimal(987.65)) ;
		return item ;
	}
}
