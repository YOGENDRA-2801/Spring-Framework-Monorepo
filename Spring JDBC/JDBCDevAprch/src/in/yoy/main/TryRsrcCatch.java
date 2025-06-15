package in.yoy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TryRsrcCatch 
{
	public static void main(String[] args) 
	{
//		VLAUES FROM USER 
		String address="NALPADA , THANE , MH" ;
		
//		SQL QUERY
		String sqlQuery = "SELECT * FROM CUSTOMER WHERE address=?" ;
				
//		CONNECTION RESOURCES
		String driverClass = "com.mysql.cj.jdbc.Driver" ;
		String url = "jdbc:mysql://127.0.0.1:3306/user?" +
					 "allowPublicKeyRetrieval=true" + 
					 "&useSSL=false" ;
		String username = "root" ;
		String password = "ABCxyz123@" ;
		
		try 
		{
			Class.forName(driverClass);
			try
			(
				Connection con = DriverManager.getConnection(url, username, password) ;	
				PreparedStatement ps = con.prepareStatement(sqlQuery);
			) 
			{
				ps.setString(1, address);
				try
				(
					ResultSet rs = ps.executeQuery() ;
				)
				{
					while(rs.next()) 
					{
						System.out.println( "ID :- " + rs.getString("id") );
						System.out.println( "NAME :- " + rs.getString("name") );
						System.out.println( "EMAIL :- " + rs.getString("email") );
						System.out.println( "PHONE :- " + rs.getString("phone") );
						System.out.println( "ADDRESS :- " + rs.getString("address") );
						System.out.println( "CREATED DATE :- " + rs.getString("createdAt") );
						System.out.println("----------");
					}
				}
			}
		} 
		catch (ClassNotFoundException | SQLException se_cnfe) 
		{
			se_cnfe.printStackTrace();
		}
	}
}
