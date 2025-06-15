package in.yoy.loggingViaJUL;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test3 
{
//	----- LOGGER ADD KIYA -----
	private static final Logger logger = Logger.getLogger(Test3.class.getName());
	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("----- START -----");
		
//		----- HANDLER & FORMATTER CREATE KIYA + FORMATTER ADD KIYA -----
		FileHandler fileHandler = new FileHandler("C:\\\\DEMO FOLDER\\FHLogFile.log"); // throws IOE 
//		Argument for FileHandler() is a string pattern that should represent the location of output file
//		Ager file  already present nahi rehega to wah create kr dega 
		SimpleFormatter simpleFormatter = new SimpleFormatter();
		fileHandler.setFormatter(simpleFormatter);
		
//		----- HANDLER ADD KIYA + LEVEL SET KIYA
		logger.setLevel(Level.WARNING);
		logger.addHandler(fileHandler);
		
//		----- LOG RECORDS ADD KIYA -----
		logger.log(Level.SEVERE, "Sever not responding try again later");
		logger.log(Level.WARNING, "3 invalid attempt ; yaad kr password");
		logger.log(Level.INFO, "Logged in successfully");
		
		System.out.println("----- END -----");
		
	}
}
