package in.yoy.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBUtility 
{
	private static final String driver_name = "com.mysql.cj.jdbc.Driver" ;
	private static final String url ="jdbc:mysql://127.0.0.1:3306/user?" + 
									 "allowPublicKeyRetrieval=true" + 
									 "&useSSL=false" ;
	private static final String username ="root" ;
	private static final String password ="ABCxyz123@" ;
	
	static
	{
		try 
		{
			Class.forName(driver_name) ;
		} 
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}
	}
	
	public static Connection createConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password) ;
	}
	
}
