package in.yoy.SprJdbcBasic.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsingXmlConfig 
{
	public static void main(String[] args) 
	{
		System.out.println("Break Point 1");
		String path = "/in/yoy/SprJdbcBasic/resources/ApplicationContext.xml";
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(path) ;
		System.out.println("Break Point 2");
		JdbcTemplate jTemp = context.getBean("jTemp", JdbcTemplate.class) ;
		try ( Connection conn = jTemp.getDataSource().getConnection() ; )
		{
			if (conn != null) 
			{
				System.out.println("SUCCESS");
			}
			else 
			{
				System.out.println("FAILED");
			}
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		System.out.println("Break Point 3");
		context.close();
	}
}
