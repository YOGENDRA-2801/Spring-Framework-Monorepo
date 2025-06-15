package in.yoy.SprJdbcNmdParam.resources;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.yoy.SprJdbcNmdParam.beans.Boutique;

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
	
	@Bean("nmdParamJTemp")
	public NamedParameterJdbcTemplate npjt() {
		NamedParameterJdbcTemplate nmdParam = new NamedParameterJdbcTemplate(dMDS()) ;
		return nmdParam ;
	}
	
	@Bean("item")
	public Boutique freshItem() {
		Boutique item = new Boutique(102 , "Kurta" , new BigDecimal("777.77") ) ;
		return item ;
	}
	
	@Bean("mapSPS")
	public MapSqlParameterSource mapSPS() {
		MapSqlParameterSource msps = new MapSqlParameterSource() ;
		msps.addValue("key_id", freshItem().getItemId());
		msps.addValue("key_name", freshItem().getItemName());
		msps.addValue("key_price", freshItem().getItemPrice());
		return msps ;
	}
	
	@Bean("beanPropSPS")
	public BeanPropertySqlParameterSource beanPropSPS() {
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(freshItem());
		return bpsps ;
	}
}
