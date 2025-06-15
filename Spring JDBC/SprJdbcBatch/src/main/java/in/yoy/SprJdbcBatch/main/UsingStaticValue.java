package in.yoy.SprJdbcBatch.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcBatch.resources.SpringConfigFile;

public class UsingStaticValue 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		JdbcTemplate jdbcTemplate = context.getBean("JdbcTemplate", JdbcTemplate.class) ;
		
		String sqlCmd1 = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (101 , \"Shirt\" , 449.49) ;" ;
		String sqlCmd2 = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (102 , \"Kurta\" , 777.77) ;" ;
		String sqlCmd3 = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (103 , \"Suits\" , 987.65) ;" ;
		
		int[] count = jdbcTemplate.batchUpdate(sqlCmd1 , sqlCmd2 , sqlCmd3) ;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				System.out.println("SUCCESS");
			}
			else {
				System.out.println("FAILED");
			}
		}
		
		context.close();
	}
}
