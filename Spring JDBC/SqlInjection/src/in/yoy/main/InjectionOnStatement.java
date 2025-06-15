package in.yoy.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.yoy.resources.DButility;

public class InjectionOnStatement 
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
		String sqlQuery = "SELECT * FROM customer WHERE phone = '" + phoneNum + "' AND email = '" + email + "' ;" ; 
		System.out.println(sqlQuery);
//		SELECT * FROM customer WHERE phone = '1234567890' AND email = '' OR '1'='1' ; // 1234567890 ; ' OR '1'='1
//		SELECT * FROM customer WHERE phone = '9876543210' OR '1'='1' AND email = 'g' ; // OR ko phla true mila to aage nhi jata
		try 
		(
			Connection con = DButility.getConnection() ;
			Statement stmt = con.createStatement() ;
			ResultSet rs = stmt.executeQuery(sqlQuery) ; // statement k case m hum sql query executeXxx() k ander dete h;
		)
		{
			if (rs.next()) // next row rha to cursor next row pr jayega but if nahi rha to false return krga
			{
				System.out.printf("Welcome %s your residential address will be in %s", rs.getString("name") , rs.getString("address"));
				System.out.println("\n" + sqlQuery);
			}
			else 
			{
				System.out.println("INVALID CREDENTIALS ENTERED");
			}
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		
	}
}
