package in.yoy.SprJdbcBasic.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcBasic.beans.Boutique;
import in.yoy.SprJdbcBasic.resources.SpringConfigFile;

public class UsingBeanData 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
		JdbcTemplate jTemp = context.getBean("jTemplate", JdbcTemplate.class) ;
		Boutique item = context.getBean("item", Boutique.class) ;
		
		String sqlCmd= "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;" ;
		
		int count = jTemp.update(sqlCmd, new Object[] {item.getItemId() , item.getItemName() , item.getItemPrice()}) ;
		if (count>0) {	System.out.println("SUCCESS");	}
		else {	System.out.println("FAILED");	}
		
		context.close();
	}
}
