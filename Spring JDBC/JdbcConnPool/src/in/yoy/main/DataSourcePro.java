package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourcePro 
{
	public static void main(String[] args) 
	{
//		Instead of step 1 which was load and register the driver here create an object of implemented class of datasource
//		Provide the Url , Name & Password 2 the datasource object
//		Instead of loading DriverManager here we create an object of implemented class of datasource
		MysqlDataSource mds = new MysqlDataSource() ;
		mds.setUrl("jdbc:mysql://127.0.0.1:3306/user?allowPublicKeyRetrieval=true&useSSL=false");
		mds.setUser("root") ;
		mds.setPassword("ABCxyz123@") ;
		
//		Set the sql query and param value
		String sql = "INSERT INTO customer(name, email, phone, address) VALUES (?, ?, ?, ?) ;" ;
		String name = "Tom" ;
		String email = "tom@gmail.com";
		String phoneno = "9876543210" ;
		String address = "Jaipur, Rajasthan";
		
//		Establich connection & create prepared statement
		try 
		(
			Connection con = mds.getConnection() ;
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
