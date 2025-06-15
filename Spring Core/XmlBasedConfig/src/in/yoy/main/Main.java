package in.yoy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.beans.Employee;
import in.yoy.beans.Students;

public class Main 
{
	public static void main(String[] args) 
	{
		String path = "/in/yoy/resources/applicationContextUsingConsArg.xml" ;
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Students std = (Students) context.getBean("studId") ;
		System.out.println("Bean Named studId :- " + std);
//		std.display() ;
		
		Employee emp1 = (Employee) context.getBean("doori") ;
		System.out.println("Bean Named doori :- " + emp1);
//		System.out.println( "Yogendra has salary of : " + emp1.getSalary() );
		
//		Employee emp2 = (Employee) context.getBean("majboori") ;
//		System.out.println("Bean Named majboori :- " + emp2);
//		System.out.println( "Yogendra is a " + emp2.getDesignation() );
		
		Employee emp3 = (Employee) context.getBean("musibat") ;
		System.out.println("Bean Named musibat :- " + emp3);
//		System.out.println( "Yogendra has a employee code " + emp3.getEmpcode() );
		
		((AbstractApplicationContext) context).close() ;
//		((ClassPathXmlApplicationContext) context).close();
	}
}
