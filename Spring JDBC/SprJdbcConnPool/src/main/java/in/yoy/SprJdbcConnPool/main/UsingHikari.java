package in.yoy.SprJdbcConnPool.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprJdbcConnPool.resources.SpringConfigFile;

public class UsingHikari 
{
	public static void main(String[] args) throws SQLException
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		DataSource hikariDataSource = context.getBean("hikariDataSource", DataSource.class) ;
		
		Connection conn1 = hikariDataSource.getConnection() ;
		Connection conn2 = hikariDataSource.getConnection() ;
		
		if (conn1 != null && conn2 != null) {
			System.out.println("SUCESS");
		}
		else {
			System.out.println("FAILED");
		}
		
		conn1.close();
		conn2.close();
		
		context.close();
	}
}
