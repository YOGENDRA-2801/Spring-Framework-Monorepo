package in.yoy.SprJdbcNmdParam.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.yoy.SprJdbcNmdParam.resources.SpringConfigFile;

public class UsingBeanPropSPS {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

		NamedParameterJdbcTemplate nmdParam = context.getBean("nmdParamJTemp", NamedParameterJdbcTemplate.class);
		BeanPropertySqlParameterSource beanPropSPS = context.getBean("beanPropSPS", BeanPropertySqlParameterSource.class);
		
		String sqlCmd = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (:itemId ,:itemName ,:itemPrice ) ;" ;
//		here param name should be same as that of instance variable name of bean class
		int count = nmdParam.update(sqlCmd, beanPropSPS) ;
		if (count>0) { System.out.println("SUCCESS"); }
		else { System.out.println("FAILED"); }
		
		context.close();
	}
}
