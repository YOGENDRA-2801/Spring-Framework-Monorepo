package in.yoy.loggingViaJUL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test1 
{
	private static final Logger logger = Logger.getLogger(Test1.class.getName()) ; 
//	Logger object get kiya 
//	isko class level p hi declare krna becoz private method level p kaam nahi krta
	
	public static void main(String[] args) {
		logger.log(Level.SEVERE, "Sever not responding try again later");
		logger.log(Level.WARNING, "3 invalid attempt ; yaad kr password");
		logger.log(Level.INFO, "Logged in successfully");
	}
}
