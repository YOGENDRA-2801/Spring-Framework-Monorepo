package in.yoy.loggingViaLog4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Test1 
{
//	LOGGER ADDED
	private static final Logger logger = LogManager.getLogger(Test1.class) ;
	
	public static void main(String[] args) {
		
//		DEFAULT CONFIGURATION
		BasicConfigurator.configure(); 
		
//		LOG REPORT EMITTED
		logger.fatal("There is an fatal error");
		logger.error("There is an Error in the progam");
		logger.warn("Please consider this warning and improve your execution");
		logger.info("This is an information");
		
	}
}
