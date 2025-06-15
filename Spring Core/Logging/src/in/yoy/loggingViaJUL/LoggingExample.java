package in.yoy.loggingViaJUL;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingExample 
{
	private static final Logger logger = Logger.getLogger(LoggingExample.class.getName()) ;
	
	public static void main(String[] args) throws IOException
	{
		logger.setLevel(Level.FINE); // Set logger to capture FINE and above
		
//		HANDLER SPECIFIED LEVEL RANGE KE SAARE LOG REPORT PRINT KRTA HAI IF AVAILABLE
		
		System.out.println("-----CONSOLE LOGGER EXAMPLE-----");
		ConsoleHandler ch = new ConsoleHandler() ;
		ch.setLevel(Level.WARNING);
		ch.setFormatter(new SimpleFormatter());
		logger.addHandler(ch);
		
		logger.setUseParentHandlers(false);
		 
		System.out.println("-----FILE HANDLER EXAMPLE WITH APPEND MODE-----");
		FileHandler fh = new FileHandler("C:\\\\DEMO FOLDER\\FHWithAppend.log", true) ; 
		fh.setLevel(Level.INFO);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		 logger.fine("Fine-grained debug message"); // Filtered out (Level.FINE, below INFO for file, below WARNING for console)
	     logger.info("Application has started");  // Logged to application.log (INFO level)
	     logger.warning("Low memory warning");    // Logged to console and file
	     logger.severe("Unhandled exception!");  // Logged to console and file
	     
//	     Simulate an exception and log it
	     try {
			throw new IllegalArgumentException("BAD INPUT") ;
		} catch (IllegalArgumentException iae) {
			logger.log(Level.SEVERE, "Exception Occured", iae); // Logs exception stack trace
		}
	}
}
