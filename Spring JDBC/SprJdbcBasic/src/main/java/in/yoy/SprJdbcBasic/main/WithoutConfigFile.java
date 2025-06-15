package in.yoy.SprJdbcBasic.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class WithoutConfigFile 
{
	public static void main(String[] args) throws SQLException
	{
//		Creating and setting up datasource
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spr_jdbc"
				+ "?allowPublicKeyRetrival=true"
				+ "&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("ABCxyz123@");
		
//		Establishing Connection - hum jtemp k through bhi conn crt kr skte hai it will be crtd based on provided datasource
//		Connection establish krne k liye Jtemplate ko Datasource ka need pdta hai 
		JdbcTemplate jtemp = new JdbcTemplate(dataSource) ;
//		jtemp.setDataSource(dataSource); // you can use this ager uper constructor me argument nahi pass krwana h to
		Connection conn = jtemp.getDataSource().getConnection() ;
		if (conn != null) {
			System.out.println("SUCCESS");
		}
		else {
			System.out.println("Failed");
		}
		conn.close();
	}
}
