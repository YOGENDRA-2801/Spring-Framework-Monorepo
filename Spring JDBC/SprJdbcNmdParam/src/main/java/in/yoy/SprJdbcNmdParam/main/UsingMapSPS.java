package in.yoy.SprJdbcNmdParam.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.yoy.SprJdbcNmdParam.beans.Boutique;
import in.yoy.SprJdbcNmdParam.resources.SpringConfigFile;

public class UsingMapSPS 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
		NamedParameterJdbcTemplate nmdParam = context.getBean("nmdParamJTemp", NamedParameterJdbcTemplate.class);
		Boutique item = context.getBean("item", Boutique.class) ;
		
//		----- WAY 1 CREATING OBJECT HERE WITHOUT USING METHOD CHAINING -----
//		MapSqlParameterSource mapSPS = new MapSqlParameterSource() ;
//		mapSPS.addValue("key_id", item.getItemId());
//		mapSPS.addValue("key_name", item.getItemName());
//		mapSPS.addValue("key_price", item.getItemPrice());
		
//		----- WAY 2 CREATING OBJECT HERE AND USING METHOD CHAINING -----
//		MapSqlParameterSource mapSPS = new MapSqlParameterSource() ;
//		mapSPS.addValue("key_id", item.getItemId()).
//		addValue("key_name", item.getItemName()).
//		addValue("key_price", item.getItemPrice()) ;
		
//		----- WAY 3 CREATING OBJECT OBJECT IN CONFIG FILE -----
		MapSqlParameterSource mapSPS = context.getBean("mapSPS", MapSqlParameterSource.class) ;
		
		String sqlCmd = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (:key_id ,:key_name ,:key_price ) ;" ;
		int count = nmdParam.update(sqlCmd, mapSPS) ;
		if (count>0) { System.out.println("SUCCESS"); }
		else { System.out.println("FAILED"); }
		
		context.close();
	}
}
