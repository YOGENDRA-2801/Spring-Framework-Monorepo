package in.yoy.main;

import java.lang.management.ManagementFactory;
import java.sql.Connection;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Pooling data ka statistics/metrics dekhne ka tarika 
// Demonstrate Manual registration of of hakari
public class ConnPool2 
{
	public static void main(String[] args) 
	{
		HikariConfig hc = new HikariConfig() ;
		hc.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/user?allowPublicKeyRetrieval=true&useSSL=false");
		hc.setUsername("root");
		hc.setPassword("ABCxyz123@") ;
		
		hc.setMaximumPoolSize(9);
//		Lazy Connection Creation :starting m 9 conn crt nhi krta demand k hisab s krta h, getConnection() call pr conn crt krta
//		minimumIdle setting agar set nahi kiya to default value rahegi
//		Agar explicitly setMinimumIdle(9) nhi karoge, to woh background mein gradually idle con'ss create krga
		
		try 
		(
			HikariDataSource hds = new HikariDataSource(hc); // rqrd_only--HikariDataSource hds;
			Connection con1 = hds.getConnection() ;
			Connection con2 = hds.getConnection() ;
			Connection con3 = hds.getConnection() ;
			Connection con4 = hds.getConnection() ;
			Connection con5 = hds.getConnection() ;
			Connection con6 = hds.getConnection() ;
			Connection con7 = hds.getConnection() ;
			Connection con8 = hds.getConnection() ;
			Connection con9 = hds.getConnection() ;
//More than limit krna hai to existing conn close hone k baad new conn estb krna(move *rqrd* ref out of try block 2 inc scope)
		)
		{
//			----- STEP 1 REGISTERING HIKARICP POOL AS MBEAN -----
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
			// 1. Get the platform MBeanServer (the JVM’s built-in registry for JMX beans)
			ObjectName on = new ObjectName("com.zaxxer.hikari:type=Pool(" + hds.getPoolName() + ")");//rqrd_only-ObjectName on;
			// 2. Construct a unique ObjectName for your Hikari pool
			mbs.registerMBean(hds.getHikariPoolMXBean(), on) ;
			// 3. Register Hikari’s MXBean with that name, so JMX tools can pick it up
			
//			----- STEP 2 ACCESS THE POOL STATISTICS USING JMX ATTRIBUTES -----
			int activeConn = (int) mbs.getAttribute(on, "ActiveConnections") ; // how many connections are in use
			int idleConn = (int) mbs.getAttribute(on, "IdleConnections") ; // how many are sitting idle
			int thrdAwatConn = (int) mbs.getAttribute(on, "ThreadsAwaitingConnection");//count of thrds blckd waiting for conn
			
			int totalConn = (int) mbs.getAttribute(on, "TotalConnections") ; // current pool size & seedha total nahi dikhata.
//			TotalConnections wo hota hai jitne connections pool mein actually ab tak create hue hain, na ki jitna tumne config 
//			mein diya. Agar tumhe start hote hi sab dikhe, to minimumIdle(9) ya upar ke tricks use kar sakte ho.
			
			System.out.println("Total Connection : "+totalConn);
			System.out.println("Active Connection : "+activeConn);
			System.out.println("Idle Connection : "+idleConn);
			System.out.println("Threads Awaiting Connection : " + thrdAwatConn);
			
		} 
		catch (Exception se) 
		{
			se.printStackTrace();
		}
	}
}
