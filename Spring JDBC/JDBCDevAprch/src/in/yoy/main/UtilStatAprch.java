package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.yoy.resources.DatabaseUtility;

public class UtilStatAprch 
{
	public static void main(String[] args) 
	{
//		VALUES FROM USER 
		String address = "NALPADA , THANE , MH" ;
		
//		SQL QUERY
		String sqlQuery = "SELECT * FROM CUSTOMER WHERE address=?" ;
		
		try 
		(
			Connection con = DatabaseUtility.getConnection() ;
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
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
}
