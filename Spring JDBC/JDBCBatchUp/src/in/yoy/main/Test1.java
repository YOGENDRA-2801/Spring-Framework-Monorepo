package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 
{
	public static void main(String[] args) 
	{
//		USER INPUTS
		String name1="Tom"; String email1="tom@gmail.com"; String phone1="5432167890"; String address1="Sapahi, Jaunpur, UP";
		String name2="Saturn"; String email2="sat@gmail.com"; String phone2="1234567890"; String address2="Nalpada, Thane, MH";
		String name3="Dev"; String email3="dev@gmail.com"; String phone3="6789054321"; String address3="Raudi, Alirajpur, MP";
		
//		int incorrectinput = 99 ;
		
//		SQL QUERY
		String sqlQuery = "INSERT INTO customer(name, email, phone, address) VALUES ( ? , ? , ? , ? ) ;" ;
		
		try 
		(
			Connection con = DBUtility.getConnection() ;
			PreparedStatement ps = con.prepareStatement(sqlQuery) ;
		)
		{
			ps.setString(1, name1); ps.setString(2, email1); ps.setString(3, phone1); ps.setString(4, address1); ps.addBatch();
			ps.setString(1, name2); ps.setString(2, email2); ps.setString(3, phone2); ps.setString(4, address2); ps.addBatch();
			ps.setString(1, name3); ps.setString(2, email3); ps.setString(3, phone3); ps.setString(4, address3); ps.addBatch();
			
//			1. Single PreparedStatement with Multiple Parameter Sets : JDBC driver internally ek list maintain karta hai, 
//			jismein aapke saare parameter sets store ho jate hain. Har baar jab aap ps.setXXX() se values set karte ho aur 
//			ps.addBatch() call karte ho, to woh current set of parameters us list me add ho jata hai.
			
//			2. Execution: Jab aap ps.executeBatch() call karte ho, to driver us list ke saare entries ko iterate karta hai aur 
//			ek-ek karke us SQL statement ko in parameter sets ke saath execute karta hai. Is tarah, ek hi pre-compiled SQL 
//			statement reuse ho jata hai for all operations.
			
			int[] cunt = ps.executeBatch() ;
			for (int i : cunt) 
			{
				System.out.println(i + " -- Executed Correctly");
			}
			ps.clearBatch();
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
}
