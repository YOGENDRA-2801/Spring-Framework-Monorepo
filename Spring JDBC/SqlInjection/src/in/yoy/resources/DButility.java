package in.yoy.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility 
{
//	JDBC CONNECTION RESOURCES
	private static final String driverClass = "com.mysql.cj.jdbc.Driver" ;
	private static final String url = "jdbc:mysql://127.0.0.1:3306/user?" +
				 					  "allowPublicKeyRetrieval=true" + 
				 					  "&useSSL=false" ;
	private static final String username = "root" ;
	private static final String password = "ABCxyz123@" ;
	
//	LOAD & REGISTER DRIVER
	static 
	{
		try 
		{
			Class.forName(driverClass) ;
		} 
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}
	}
	
//	ESTABLISH CONNECTION
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password) ;
	}
	
}
