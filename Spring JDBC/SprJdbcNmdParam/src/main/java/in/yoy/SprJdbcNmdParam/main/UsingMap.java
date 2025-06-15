package in.yoy.SprJdbcNmdParam.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.yoy.SprJdbcNmdParam.beans.Boutique;
import in.yoy.SprJdbcNmdParam.resources.SpringConfigFile;

public class UsingMap 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
		NamedParameterJdbcTemplate nmdParam = context.getBean("nmdParamJTemp", NamedParameterJdbcTemplate.class);
		Boutique item = context.getBean("item", Boutique.class) ;
		
		Map<String, Object> map = new HashMap<String, Object>() ;
		map.put("key_id", item.getItemId()) ;
		map.put("key_name", item.getItemName()) ;
		map.put("key_price", item.getItemPrice()) ;
		
		String sqlCmd = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (:key_id ,:key_name ,:key_price ) ;" ;
		int count = nmdParam.update(sqlCmd, map) ;
		if (count>0) { System.out.println("SUCCESS"); }
		else { System.out.println("FAILED"); }
		
		context.close();
	}
}
