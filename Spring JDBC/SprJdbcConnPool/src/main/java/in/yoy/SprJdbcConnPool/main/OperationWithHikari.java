package in.yoy.SprJdbcConnPool.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcConnPool.resources.SpringConfigFile;

public class OperationWithHikari 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		
		String sqlCmd = "UPDATE boutique SET item_id=? WHERE item_name=? ;" ;
		Object[] itemArray1 = {1, "Shirt"} ;
		Object[] itemArray2 = {2, "Kurta"} ;
		Object[] itemArray3 = {3, "Suits"} ;
		
		int count1 = jdbcTemplate.update(sqlCmd, itemArray1) ;
		int count2 = jdbcTemplate.update(sqlCmd, itemArray2) ;
		int count3 = jdbcTemplate.update(sqlCmd, itemArray3) ;
		
		if (count1>0 && count2>0 && count3>0) {	System.out.println("SUCCESS");	}
		else {	System.out.println("FAILED");	}
		
		context.close();
	}
}
