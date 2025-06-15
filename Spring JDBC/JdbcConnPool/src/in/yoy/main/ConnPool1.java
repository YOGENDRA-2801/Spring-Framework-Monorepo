package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// HIKARI USAGE PROGRAM
public class ConnPool1 
{
	public static void main(String[] args) 
	{
//		Provide the configuration & pool detail to setup the data source 
		HikariConfig hc = new HikariConfig() ;
		hc.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/user?allowPublicKeyRetrieval=true&useSSL=false");
		hc.setUsername("root");
		hc.setPassword("ABCxyz123@") ;
		hc.setMaximumPoolSize(10);
		
//		Set the sql query and param value
		String sql = "INSERT INTO customer(name, email, phone, address) VALUES (?, ?, ?, ?) ;" ;
		String name = "Luke" ;
		String email = "luke@gmail.com";
		String phoneno = "6789054321" ;
		String address = "Indore, Madhyapradesh";
		
//		Create datasource (instead of loading the driver) , Establich connection & create prepared statement
		try 
		(
			HikariDataSource hds = new HikariDataSource(hc);
			Connection con = hds.getConnection() ;
			PreparedStatement ps = con.prepareStatement(sql);
		)
		{
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phoneno);
			ps.setString(4, address);
			
//			Send & execute sql query
			int status = ps.executeUpdate() ;
			
//			Process the result
			if (status>0) {
				System.out.println("Query executed correctly");
			}
			else {
				System.out.println("Execution Failed");
			}
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
}
