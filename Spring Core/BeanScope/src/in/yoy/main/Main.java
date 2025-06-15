package in.yoy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import in.yoy.beans.*;
import in.yoy.resources.* ;

public class Main {
	
	public static void main(String[] args) {
		
//		String path = "/in/yoy/resources/applicationContext.xml" ;
//		ApplicationContext context = new ClassPathXmlApplicationContext(path) ;
//		Student stud1 = (Student) context.getBean("std1") ;
//		Student stud2 = (Student) context.getBean("std1") ;
//		System.out.println(stud1.equals(stud2));
//		System.out.println(stud1==stud2);
//		System.out.println("stud1 : " + stud1 + " \nstud2 : " + stud2);
		
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
//		Employee emp1 = (Employee) context.getBean("majdoor") ;
//		Employee emp2 = (Employee) context.getBean("majdoor") ;
//		System.out.println(emp1.equals(emp2));
//		System.out.println(emp1 == emp2);
//		System.out.println("stud1 : " + emp1 + " \nstud2 : " + emp2);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AJ_ConfigFile.class) ;
		Family f1 = (Family) context.getBean("pariwar") ;
		Family f2 = (Family) context.getBean("pariwar") ;
		System.out.println("f1 : " + f1 + "\nf2 : " + f2);
		System.out.println(f1 == f2);
		System.out.println(f1.equals(f2));
		
		((AbstractApplicationContext) context).close() ;
		
	}

}
