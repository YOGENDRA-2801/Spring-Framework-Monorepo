package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.yoy.resources.DButility;

public class InjectionOnPS 
{
	public static void main(String[] args) 
	{
//		VALUES FROM USER
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter Your Phone Number : ");
		String phoneNum = sc.nextLine() ;
		System.out.println("Enter Your Email-ID : ");
		String email = sc.nextLine() ;
		sc.close();
		
//		SQL QUERY
		String sqlQuery = "SELECT * FROM customer WHERE phone=? AND email=? ;" ;
		
		try 
		(
			Connection con = DButility.getConnection() ;
			PreparedStatement ps = con.prepareStatement(sqlQuery) ;
		)
		{
			ps.setString(1, phoneNum);
			ps.setString(2, email);
			try 
			(
				ResultSet rs = ps.executeQuery() ;
			)
			{
				if (rs.next()) // next row rha to cursor next row pr jayega but if nahi rha to false return krga
				{
					System.out.printf("Welcome %s your residential address will be in %s", rs.getString("name") , rs.getString("address"));
					System.out.println("\n\n" + sqlQuery);
				}
				else 
				{
					System.out.println("INVALID CREDENTIALS ENTERED");
				}
			}
		}
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		
	}
}
