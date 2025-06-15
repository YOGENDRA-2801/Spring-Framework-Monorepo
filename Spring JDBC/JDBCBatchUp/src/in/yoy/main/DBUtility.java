package in.yoy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
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
			Class.forName(driverClass) ; // jb getConnection call hua tab hi yah block execute ho gaya as class load hua tha
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
