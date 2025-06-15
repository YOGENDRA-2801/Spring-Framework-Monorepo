package in.yoy.SprJdbcBasic.resources;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.yoy.SprJdbcBasic.beans.Boutique;

@Configuration
public class SpringConfigFile 
{
	@Bean("dMDataSource")
	public DriverManagerDataSource dMDS() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_jdbc");
		dataSource.setUsername("root") ;
		dataSource.setPassword("ABCxyz123@") ;
		return dataSource ;
	}
	
	@Bean("jTemplate")
	public JdbcTemplate jtemp() {
		JdbcTemplate jt = new JdbcTemplate() ;
		jt.setDataSource(dMDS());
		return jt ;
	}
	
	@Bean("item")
	public Boutique freshItem() {
		Boutique item = new Boutique(103 , "Suits" , new BigDecimal("987.65") ) ;
		return item ;
	}
}
