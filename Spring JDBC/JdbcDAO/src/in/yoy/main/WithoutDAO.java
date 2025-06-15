package in.yoy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithoutDAO 
{
	public static void main(String[] args) throws ClassNotFoundException , SQLException
	{
//		1. LOAD & REGISTER THE DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver") ;
//		2. ESTABLISH CONNECTION
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spr_jdbc?"
				+ "allowPublicKeyRetrieval=true&"
				+ "useSSL=false" , "root" , "ABCxyz123@") ;
		 ;
//		3. CREATE STATEMENT OBJECT
		String sqlCmdString = "SELECT * FROM boutique WHERE item_id=? OR item_id=? ;";
		PreparedStatement ps = con.prepareStatement(sqlCmdString) ;
		ps.setInt(1, 1) ;
		ps.setInt(2, 2) ;
//		4. EXECUTE SQL QUERIES
		ResultSet rs = ps.executeQuery() ;
//		5. PROCESS RESULT FROM RESULT SET
		while (rs.next()) {
			System.out.println("ITEM ID : " + rs.getInt("item_id"));
			System.out.println("ITEM ID : " + rs.getString("item_name"));
			System.out.println("ITEM ID : " + rs.getBigDecimal("item_price"));
			System.out.println();
		}
//		6. CLOSE THE CONNECTION 
		con.close() ;
	}
}
