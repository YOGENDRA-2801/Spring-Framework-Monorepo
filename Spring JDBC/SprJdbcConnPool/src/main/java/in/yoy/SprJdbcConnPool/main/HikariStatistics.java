package in.yoy.SprJdbcConnPool.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

import in.yoy.SprJdbcConnPool.resources.SpringConfigFile;

public class HikariStatistics 
{
	public static void main(String[] args) throws SQLException
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
//		-------------------------------------------------------------------------------------------------
		HikariDataSource hikariDataSource = context.getBean("hikariDataSource", HikariDataSource.class) ;
//		Second argument me jis class ka naam doge spring uss bean ko uss class type m cast krke reference me store karega
//		Ess case me 2 tarike se error aa sakte hai 
//		1. ager tune koi aesa class name mention kiya 2nd argument me jo actual bean object se compatible hi nahi hai
//		2. 2nd argument sahi provide kiya but store krne k liye jo reference type select kiya wah compatible nhi hai
//		Remainder : Child object ko Parent reference me store kr skte hai but vice versa is not true.
//		-------------------------------------------------------------------------------------------------
		
		try 
		(
			Connection conn1 = hikariDataSource.getConnection() ;
			Connection conn2 = hikariDataSource.getConnection() ;
			Connection conn3 = hikariDataSource.getConnection() ;
			Connection conn4 = hikariDataSource.getConnection() ;
		)
		{
			int active_connections = hikariDataSource.getHikariPoolMXBean().getActiveConnections();
	        int idle_connections = hikariDataSource.getHikariPoolMXBean().getIdleConnections();
	        int total_connections = hikariDataSource.getHikariPoolMXBean().getTotalConnections();
			int thrdAwaitConn = hikariDataSource.getHikariPoolMXBean().getThreadsAwaitingConnection();
			int maxPoolSize = hikariDataSource.getMaximumPoolSize() ;
			
			System.out.println("Total Connection : "+total_connections);
			System.out.println("Active Connection : "+active_connections);
			System.out.println("Idle Connection : "+idle_connections);
			System.out.println("Threads Awaiting Connection : " + thrdAwaitConn);
			System.out.println("Maximum Pool Size : " + maxPoolSize);
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		
		context.close();
	}
}
