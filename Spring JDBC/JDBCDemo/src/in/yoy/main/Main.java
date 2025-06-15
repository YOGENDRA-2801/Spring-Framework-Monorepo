package in.yoy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main 
{
	public static void main(String[] args) throws ClassNotFoundException , SQLException
	{
		
//		1. LOAD AND REGISTER DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver"); // DRIVER CLASS NAME
		
//		2. ESTABLISH CONNECTION 
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root" , "ABCxyz123@") ;
		
		con.close() ;
	}
}
