package in.yoy.SprJdbcConnPool.resources;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SpringConfigFile 
{
	@Bean("hikariDataSource")
	public DataSource createDataSource() {		
		HikariConfig hikariConfig = new HikariConfig() ;
		hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/spr_jdbc");
		hikariConfig.setUsername("root") ;
		hikariConfig.setPassword("ABCxyz123@") ;
		hikariConfig.setMaximumPoolSize(5) ;
//		-------------------------------------
		hikariConfig.setRegisterMbeans(true); 
//		1. Enables JMX registration of Hikari’s internal HikariPoolMXBean with the platform MBeanServer.
//		2. Real-time visibility , Standardized monitoring , Alerting & auto-healing
//		3. Turn it on if you need external, JMX-based visibility and are comfortable managing the extra lifecycle and security 
//		   considerations..
//
//		1. If you don’t register it, Hikari will still work perfectly—dataSource.getHikariPoolMXBean() will return a local 
//		   view of the metrics—but no MBean gets registered for external JMX clients.
//		2. Leave it off for lightweight apps, jobs, or when you’re already getting metrics via Actuator/Micrometer and don’t 
//		   need raw JMX beans.
//		3. By default false hi rhta hai
//		-------------------------------------		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig) ;
		return hikariDataSource ;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource()) ;
		return jdbcTemplate ;
	}
}



