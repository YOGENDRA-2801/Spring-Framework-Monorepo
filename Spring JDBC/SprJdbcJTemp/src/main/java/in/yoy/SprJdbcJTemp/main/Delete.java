package in.yoy.SprJdbcJTemp.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcJTemp.resources.SpringConfigFile;

public class Delete 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
//		Bean Object of JdbcTemplate
		JdbcTemplate jtemp = context.getBean("jTemplate", JdbcTemplate.class);
		
//		Values from user
		int item_id = 102 ;
		
		String sqlCmd = "DELETE FROM boutique WHERE item_id=? ;" ;
		
		int count = jtemp.update(sqlCmd, item_id) ;
		if (count>0) {	System.out.println("SUCCESS");	}
		else {	System.out.println("FAILED");	}
		
		context.close();
	}
}
