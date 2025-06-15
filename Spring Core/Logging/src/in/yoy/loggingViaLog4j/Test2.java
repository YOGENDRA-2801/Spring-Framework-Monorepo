package in.yoy.loggingViaLog4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test2 
{
	private static final Logger logger = LogManager.getLogger(Test2.class) ;
	public static void main(String[] args) {
//		CONFIGRURATION
//		BY DEFAULT LAG4J CONFIG K LIYE SRC\ MAIN\RESOUCRCES M JAKE DEKHTA HAI 
		
		
//		LOG RECORDS
		logger.fatal("There is an fatal error");
		logger.error("There is an Error in the progam");
		logger.warn("Please consider this warning and improve your execution");
		logger.info("This is an information");
	}
}
