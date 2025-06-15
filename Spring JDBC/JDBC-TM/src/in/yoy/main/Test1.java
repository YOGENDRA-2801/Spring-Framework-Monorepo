package in.yoy.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//	WITHOUT USING BATCH UPDATE METHOD
public class Test1 
{
	public static void main(String[] args) 
	{
//		USER INPUTS
		String name1="Tom"; String email1="tom@gmail.com"; String phone1="5432167890"; String address1="Sapahi, Jaunpur, UP";
		String name2="Saturn"; String email2="sat@gmail.com"; String phone2="1234567890"; String address2="Nalpada, Thane, MH";
		String name3="Dev"; String email3="dev@gmail.com"; String phone3="6789054321"; String address3="Raudi, Alirajpur, MP";
		
//		SQL QUERY
		String sqlQuery = "INSERT INTO customer(name, email, phone, address) VALUES ( ? , ? , ? , ? ) ;" ;
		
		Connection con = null ; // BAHR LIKHA TAKI FINALLY M CLOSE KR SAKU TRY M LIKHTA TO FINALLY TK SCOPE NAHI RHTA ISKA
		try 
		{
			con = DBUtility.createConnection() ; // THROWS SQL EXCEPTION HENCE MUST BE IN TRY BLOCK
			con.setAutoCommit(false) ;
			try 
			(
//				YHA SE CON HATAYA BCOZ EXCPTN PR BHI MUJHE ROLLBACK KRNA THA BUT CON ACCESIBLE NAHI THA
				PreparedStatement ps1 = con.prepareStatement(sqlQuery) ;
				PreparedStatement ps2 = con.prepareStatement(sqlQuery) ;
				PreparedStatement ps3 = con.prepareStatement(sqlQuery) ;
			)
			{
				ps1.setString(1, name1); ps1.setString(2, email1); ps1.setString(3, phone1); ps1.setString(4, address1); 
				ps2.setString(1, name2); ps2.setString(2, email2); ps2.setString(3, phone2); ps2.setString(4, address2); 
				ps3.setString(1, name3); ps3.setString(2, email3); ps3.setString(3, phone3); ps3.setString(4, address3); 
				
				int cunt1 = ps1.executeUpdate();
				int cunt2 = ps2.executeUpdate();
				int cunt3 = ps3.executeUpdate();
				
				if (cunt1>0 && cunt2>0 && cunt3>0) 
				{
					con.commit();
					System.out.println("TRANSACTION COMPLETED");
				}
				else 
				{
					con.rollback();
					System.out.println("TRANSACTION FAILED DUE TO ERROR IN SQL CMD");
				}
			} 
			catch (SQLException se) 
			{
				con.rollback();
				System.out.println("TRANSACTION FAILED DUE TO AN EXCEPTION");
				se.printStackTrace();
			}
		}
		catch (SQLException se) 
		{
			se.printStackTrace();
			System.out.println("CONNECTION CREATION K SAMAY EXCEPTION AAYA HAI");
		}
		finally 
		{
			try 
			{
				if (con != null) // yeh if condition defensive programming ka ek best practice hai. Agar kisi reason se connection object null ho gaya to bina null check ke con.close() call karne se NullPointerException aa sakta hai
				{
					con.setAutoCommit(true);
					con.close(); // THROWS SQL EXCEPTION
				}							
			} 
			catch (SQLException se) 
			{
				se.printStackTrace();
				System.out.println("CONNECTION CLOSING KE SAMAY EXCEPTION AAYA HAI");
			}
		}
	}
}
