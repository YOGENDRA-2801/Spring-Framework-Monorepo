package in.yoy.SprJdbcJTemp.main;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcJTemp.beans.Boutique ;
import in.yoy.SprJdbcJTemp.resources.SpringConfigFile;

public class Insert 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
//		Object of JdbcTemplate & Beans
		JdbcTemplate jtemp = context.getBean("jTemplate", JdbcTemplate.class);
		Boutique item = context.getBean("item", Boutique.class) ;
		
//		Values from user
		int item_id = 102 ;
		String item_name = "Kurta" ;
		BigDecimal item_price = new BigDecimal("777.77") ;
		
//		----- WAY 1 = NOT RECOMMENDED DUE TO SQLINJECTION -----
//		String sqlQuery = "INSERT INTO boutique (item_id, item_name, item_price) VALUES ("+item_id+" , '"+item_name+"' , "+item_price+") ;" ;
//		System.out.println(sqlQuery);
//		int count1 = jtemp.update(sqlQuery) ;
//		if (count1>0) {	System.out.println("SUCCESS");	}
//		else {	System.out.println("FAILED");	}
		
//		----- WAY 2 = jb direct values pass kar rahe ho -----
//		String sqlString = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;" ;
//		int count2 = jtemp.update(sqlString, item_id , item_name , item_price) ;
//		if (count2>0) {	System.out.println("SUCCESS");	}
//		else {	System.out.println("FAILED");	}
		
//		----- WAY 3 = jb dynamic values handle karna chahte ho (jaise dynamic mapping, ya loop se values generate) -----
//		String sqlCmd= "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;" ;
//		int count3 = jtemp.update(sqlCmd, new Object[] {item_id , item_name , item_price}) ;
//		if (count3>0) {	System.out.println("SUCCESS");	}
//		else {	System.out.println("FAILED");	}
		
//		----- WAY 4 -----
		String sqlCmd= "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;" ;
		int count = jtemp.update(sqlCmd, new Object[] {item.getItemId() , item.getItemName() , item.getItemPrice()}) ;
		if (count>0) {	System.out.println("SUCCESS");	}
		else {	System.out.println("FAILED");	}
		
		context.close();
	}
}
