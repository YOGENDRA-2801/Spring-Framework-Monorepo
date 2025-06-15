package in.yoy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TryCatchFinally 
{
	public static void main(String[] args) 
	{
//		VLAUES FROM USER 
		String name="Satish" ;
		String email="sat@gmail.com"; 
		String phone="1234567890"; 
		String address="Nalpada, Thane, MH" ;
		
//		SQL QUERY
		String sqlQuery = "INSERT INTO customer(name, email, phone, address) VALUES (?,?,?,?);" ;
				
//		CONNECTION RESOURCES
		String driverClass = "com.mysql.cj.jdbc.Driver" ;
		String url = "jdbc:mysql://127.0.0.1:3306/user?" +
					 "allowPublicKeyRetrieval=true" + 
					 "&useSSL=false" ;
		String username = "root" ;
		String password = "ABCxyz123@" ;
		
		Connection con = null ;
		PreparedStatement ps = null ; 
		int result ;
		
		try 
		{
//			1. LOAD AND REGISTER THE DRIVER
			Class.forName(driverClass);
//			2. ESTABLISH CONNECTION
			con = DriverManager.getConnection(url, username, password) ;
//			3. CREATE STATEMENT OBJECT
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, name) ;
			ps.setString(2, email) ;
			ps.setString(3, phone) ;
			ps.setString(4, address) ;
//			4. SEND AND EXECUTE SQL QUERY
			result = ps.executeUpdate() ;
//			5. PROCESS RESULT FROM RESULTSET
			if (result>0) {
				System.out.println("EXECUTED SUCCESSFULLY");
			}
			else {
				System.out.println("EXECUTION FAILED");
			}
		} 
		catch ( ClassNotFoundException | SQLException se_cnfe) 
		{
			se_cnfe.printStackTrace();
		}
		finally 
		{
//			6. CLOSE CONNECTION
			try 
			{
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}				
			} 
			catch (SQLException se) 
			{
				se.printStackTrace(); 
			}
			
			
		}		
	}
}
