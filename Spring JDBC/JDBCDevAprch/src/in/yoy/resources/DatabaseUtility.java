package in.yoy.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility 
{
//	JDBC credentials (hard-coded here; you can later move to a .properties if you wish)
	private static final String driverClass = "com.mysql.cj.jdbc.Driver" ;
	private static final String url = "jdbc:mysql://127.0.0.1:3306/user?" +
				 					  "allowPublicKeyRetrieval=true" + 
				 					  "&useSSL=false" ;
	private static final String username = "root" ;
	private static final String password = "ABCxyz123@" ;
	
//	Static block to load & register the driver exactly once at the start
	static 
	{
		try 
		{
			Class.forName(driverClass) ;
		} 
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}
	}
	
//	Public helper method to obtain a brand-new Connection.
	public static Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(url, username, password);
	}
	
//	1. WHY USED THROWS NOT TRY-CATCH
//	getConnection() ka kaam sirf ek naya Connection bana ke wapas dena hai. Agar isme kuch galat ho jaaye (jaise URL wrong ho, username/password galat ho, etc.), toh agar main yahin pe try-catch karke SQLException ko handle kar loon, toh caller ko pata hi nahi chalega ki problem kahan aayi. Isliye main throws SQLException likh ke exception upar (caller tak) propagate kar deta hoon, jisse jo code is method ko call kar raha hai (jaise Test1.main), wo decide karega ki exception mile toh kya karna hai – logging, user ko message dikhana, program bandh karna, etc.
	
//	2. Resource close kyun nahi kiya gaya getConnection() mein?
//	getConnection() khud koi “open resource” nahi banata, wo sirf Connection return karta hai Jab aap DriverManager.getConnection(...) call karte ho, toh driver ke andar se ek naya Connection object create hota hai. Ussi moment koi Statement ya ResultSet nahi khulta. Sirf ek Connection banta hai, jo main wapas caller ko de deta hoon. Us Connection ko close karne ka kaam caller ka hota hai, kyunki jisne connection liya ussi ko band bhi karna hota hai.
	
//	3. Try-with-resources tabhi use hota hai jab aap resource ko ussi method/block mein open karein Agar aap getConnection() mein Connection con = DriverManager.getConnection(...) likh ke return kar dete ho, toh Connection aage caller ke paas chala jaata hai. getConnection() ke scope ke baahar connection use ho raha hota hai—iska matlab ye method khatam ho gaya aur connection abhi bhi open hai. Isliye wahan pe (meth k ander) close nahi kiya ja sakta. Jo code getConnection() ko call karta hai (jaise Test1.main), vo use try-with-resources ya finally block mein close karega.
	
//	4. UtilStatAprch m driver ko register krne ki need ku nahi padi
//	Dekh bhai, driver class to actually DbUtil ke static block mein load ho rahi hai—na ki Test1 mein. Jab tu DbUtil.getConnection() call karta hai, JVM sabse pehle DbUtil class ko load karega, jiska static block ek baar run hoga: Iska matlab jab bhi tu DbUtil.getConnection() call karega, driver pehle hi register ho chuka hoga. Isliye Test1 mein alag se Class.forName(...) likhne ki zarurat nahi padti. Connection driver load hone ke baad hi milta hai.
	
//	5. HELPER METHOD
//	Yeh wo chhota, focused method hota hai jo koi specific, baar‐baar waala “sub‐task” karne ke liye banaya gaya ho.
//	Chhota‐mota, ek hi cheez karta hai, almost “utility” jaisa. 
//	Ye mainly isliye hota hai ki kahi‐bhi reuse ho jaye.
//	Code ko DRY (Don’t Repeat Yourself) banata hai & Responsibility ek jagah concentrate ho jati hai
}






















