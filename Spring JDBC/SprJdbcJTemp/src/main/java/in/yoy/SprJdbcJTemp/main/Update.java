package in.yoy.SprJdbcJTemp.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcJTemp.resources.SpringConfigFile;

public class Update 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
//		Bean Object of JdbcTemplate
		JdbcTemplate jtemp = context.getBean("jTemplate", JdbcTemplate.class);
		
//		Values from user
		int item_id = 101 ;
		String item_name = "Shirt" ;
		
		String sqlCmd = "UPDATE boutique SET item_id=? WHERE item_name=? ;" ;
		
		int count = jtemp.update(sqlCmd, item_id, item_name) ;
		if (count>0) {	System.out.println("SUCCESS");	}
		else {	System.out.println("FAILED");	}
		
		context.close();
	}
}
