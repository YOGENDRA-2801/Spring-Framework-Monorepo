package in.yoy.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 
{
	public static void main(String[] args) throws SQLException , ClassNotFoundException
	{
//		VALUES FROM USER
		String name = "Yogendra" ;
		String newAdd = "NALPADA , THANE , MH";
		
//		1. LOAD AND REGISTER DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver"); // DRIVER CLASS NAME
		
//		2. ESTABLISH CONNECTION 
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root" , "ABCxyz123@") ;
//		HERE "user" IS THE NAME OF THE DATABASE
		
//		3. CREATE STATEMENT OBJECT
		PreparedStatement ps = con.prepareStatement("UPDATE customer SET address=? WHERE name=?;");
		ps.setString(1, newAdd) ;
		ps.setString(2, name);
		
//		4. EXECUTE SQL QUERY
		int cunt = ps.executeUpdate() ;
		
//		5. PROCESS RESULT 
		if (cunt>0) {
			System.out.println("QUERY EXECUTED SUCCESSFULLY");
		}
		else {
			System.out.println("QUERY EXECUTION FAILED");
		}
		
//		CLOSE CONNECTION
		ps.close() ;
		con.close() ;
	}
}
