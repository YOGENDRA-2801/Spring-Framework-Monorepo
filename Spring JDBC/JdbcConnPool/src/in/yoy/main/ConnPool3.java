package in.yoy.main;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

// Pooling data ka statistics/metrics dekhne ka tarika 
// Demonstrate Auto registration of of hakari
public class ConnPool3 
{
	public static void main(String[] args) 
	{
		HikariConfig hc = new HikariConfig() ;
		hc.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/user?allowPublicKeyRetrieval=true&useSSL=false");
		hc.setUsername("root");
		hc.setPassword("ABCxyz123@") ;		
		hc.setMaximumPoolSize(3);
		hc.setPoolName("myPool");
		hc.setRegisterMbeans(true);
		
		try 
		(
			HikariDataSource hds = new HikariDataSource(hc); // rqrd_only--HikariDataSource hds;
			Connection con1 = hds.getConnection() ;
			Connection con2 = hds.getConnection() ;
			Connection con3 = hds.getConnection() ;
//More than limit krna hai to existing conn close hone k baad new conn estb krna(move *rqrd* ref out of try block 2 inc scope)  
		)
		{
			HikariPoolMXBean poolProxy = hds.getHikariPoolMXBean(); // rqrd_only--HikariPoolMXBean poolProxy;
// ActiveConnections , IdleConnections , ThreadsAwaitingConnection , TotalConnections are attributes of HikariPoolMXBean
			
			int activeConn = poolProxy.getActiveConnections();
			int idleConn = poolProxy.getIdleConnections();
			int totalConn = poolProxy.getTotalConnections();
			int thrdAwaitConn = poolProxy.getThreadsAwaitingConnection();
			
			System.out.println("Total Connection : "+totalConn);
			System.out.println("Active Connection : "+activeConn);
			System.out.println("Idle Connection : "+idleConn);
			System.out.println("Threads Awaiting Connection : " + thrdAwaitConn);			
		} 
		catch (Exception se) 
		{
			se.printStackTrace();
		}
	}
}
