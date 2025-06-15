package in.yoy.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 
{
	public static void main(String[] args) throws ClassNotFoundException , SQLException
	{
//		VLAUES FROM USER 
		String name="Satish" ;
		String email="sat@gmail.com"; 
		String phone="1234567890"; 
		String address="Nalpada, Thane, MH" ;
		
//		1. LOAD AND REGISTER DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver"); // DRIVER CLASS NAME
		
//		2. ESTABLISH CONNECTION 
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root" , "ABCxyz123@") ;
//		HERE "user" IS THE NAME OF THE DATABASE
		
//		3. CREATE STATEMENT OBJECT
		PreparedStatement ps = con.prepareStatement("INSERT INTO customer(name, email, phone, address) VALUES (?,?,?,?);");
		ps.setString(1, name) ;
		ps.setString(2, email) ;
		ps.setString(3, phone) ;
		ps.setString(4, address) ;
		
//		4. EXECUTE SQL QUERY
		int cunt = ps.executeUpdate() ;
		
//		5. PROCESS RESULT
		if (cunt>0) {
			System.out.println("QUERY EXECUTED SUCCESSFULLY");
		}
		else {
			System.out.println("QUERY EXECUTION FAILED");
		}
		
//		6. CLOSE CONNECTION
		ps.close() ;
		con.close() ;		
	}
}
