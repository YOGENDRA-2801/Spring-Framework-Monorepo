package in.yoy.loggingViaJUL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test2 
{
	private static final Logger logger = Logger.getLogger(Test2.class.getName());
	
	public void meth() {
		logger.log(Level.SEVERE, "Sever not responding try again later");
		logger.log(Level.WARNING, "3 invalid attempt ; yaad kr password");
		logger.log(Level.INFO, "Logged in successfully");
	}
	
	public static void main(String[] args) {
		logger.setLevel(Level.WARNING); // threshold level set kiya 
		Test2 t2 = new Test2() ;
		t2.meth();
	}
}
