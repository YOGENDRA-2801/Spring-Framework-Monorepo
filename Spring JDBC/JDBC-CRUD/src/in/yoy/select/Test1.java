package in.yoy.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Test1 
{
	public static void main(String[] args) throws SQLException , ClassNotFoundException
	{
//		1. LOAD AND REGISTER DRIVER CLASS
		Class.forName("com.mysql.cj.jdbc.Driver");
//		2. ESTABLISH CONNECTION
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root", "ABCxyz123@") ;
//		3. CREATE STATEMENT
		PreparedStatement ps = con.prepareStatement("SELECT * FROM customer;") ;
//		4. SEND & EXECUTE SQL QUERY
		ResultSet rs = ps.executeQuery();
//		5. PROCESS RESULT FROM RESULTSET
		while (rs.next()) // next() will move the resultset cursor one by one to each row
		{
			System.out.println( "ID :- " + rs.getString("id") );
			System.out.println( "NAME :- " + rs.getString("name") );
			System.out.println( "EMAIL :- " + rs.getString("email") );
			System.out.println( "PHONE :- " + rs.getString("phone") );
			System.out.println( "ADDRESS :- " + rs.getString("address") );
			System.out.println( "CREATED DATE :- " + rs.getString("createdAt") );
			System.out.println("----------");
		}
//		6. CLOSE CONNECTION
		rs.close() ;
		ps.close() ;
		con.close() ;
	}
}
