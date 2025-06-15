package in.yoy.SprJdbcBasic.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcBasic.resources.SpringConfigFile;

public class UsingJavaConfig 
{
	public static void main(String[] args) 
	{
		System.out.println("Break Point 1");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		System.out.println("Break Point 2");
		JdbcTemplate jTemp = context.getBean("jTemplate", JdbcTemplate.class) ;
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
