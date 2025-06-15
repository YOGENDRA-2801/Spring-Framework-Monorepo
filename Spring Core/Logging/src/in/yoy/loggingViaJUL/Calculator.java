package in.yoy.loggingViaJUL;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator 
{
	private static final Logger logger = Logger.getLogger(Calculator.class.getName()) ; // LOGGER GET KIYA
	
	public static void main(String[] args) throws IOException
	{
		
		logger.setUseParentHandlers(false); // DEFAULT WALE LOGGER KO DISABLE KIYA
		
		ConsoleHandler ch = new ConsoleHandler() ; // HANDLER CREATE KIYA
		ch.setFormatter(new SimpleFormatter()); // FORMATTER ADD KIYA
		logger.addHandler(ch); // HANDLER ADD KIYA 
		
		Scanner sc = new Scanner(System.in) ;
		
		String again ;
		
		do 
		{
			
//			----- INPUT FROM USER -----
			logger.info("Enter First Number : ");
			int inp1 = sc.nextInt();
			
			logger.info("Enter Second Number : ");
			int inp2 = sc.nextInt(); 
//			Jab tu sc.nextInt(); call karta hai, woh integer read karta hai, but newline character \n ko consume nahi karta.
//			Phir nextLine(); turant woh leftover \n (enter) ko read kar leta hai — bina user input liye hi.
//			Hence Add an extra nextLine() after nextInt() calls to consume ALL the leftover newline.
			sc.nextLine() ;
			
			logger.info("Enter the required operation + , - , * , / ");
			String symbString = sc.nextLine() ;
			
//			----- PERFORMING THE GIVEN OPERATION -----
			switch (symbString) {
			case "+":
				logger.log(Level.INFO, "Answer of your requested operation is " + (inp1 + inp2) ) ;
				break;
			case "-":
				logger.log(Level.INFO, "Answer of your requested operation is " + (inp1 - inp2) ) ;
				break;
			case "*":
				logger.log(Level.INFO, "Answer of your requested operation is " + (inp1 * inp2) ) ;
				break;
			case "/":
				if( inp2 != 0 ) {
					logger.log(Level.INFO, "Answer of your requested operation is " + (inp1 / inp2) ) ; }
				else {
					logger.warning("Gadha hai kya be ?") ; }
				break;
			default:
				logger.log(Level.INFO, "Kindly choose from the given list") ;
				break;
			}
			
//			----- CONFIRMATION WHETHER TO ITERATE AGAIN OR NOT
			logger.info("Do you want to continue ? \nEnter Y for Yes and N for No : ");
			again = sc.nextLine() ;
			
		} 
		while (again.equalsIgnoreCase("Y")); 
//		again=="Y" compares object reference (memory address) in case of object type hence will not work here
//		but the == compares the value in case of primitive type
		
//		System.out.println("Sum of two Number is " + (inp1 + inp2) ); // BRACKET USED BECOZ CONCAT HO JA RHA THA 
		
		sc.close();
	}
}
