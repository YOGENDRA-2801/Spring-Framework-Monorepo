package in.yoy.log4jPart2;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoOne 
{
	private static final Logger logger = LogManager.getLogger(DemoOne.class) ;
	
	public static void main(String[] args) 
	{
//		CONFIGURATION
		
		
//		LOG RECORDS
		logger.fatal("There is an fatal error");
		logger.error("There is an Error in the progam");
		logger.warn("Please consider this warning and improve your execution");
		logger.info("This is an information");
	}
}
