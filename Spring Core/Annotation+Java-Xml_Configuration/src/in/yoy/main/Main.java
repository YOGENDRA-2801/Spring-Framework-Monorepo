package in.yoy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.beans.Employee;
import in.yoy.beans.Student;
import in.yoy.resources.SpringConfigFile;

public class Main {
	
	public static void main(String[] args) {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/resources/applicationContext.xml") ;
//		Employee emp = (Employee) context.getBean("majdoor") ;
//		System.out.println(emp.toString());
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		Student stud = (Student) context.getBean("graduate") ;
		System.out.println(stud.toString());
		
		((AbstractApplicationContext) context).close() ;
		
	}

}
