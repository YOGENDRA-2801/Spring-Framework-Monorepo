package in.yoy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.beans.Employee;
import in.yoy.beans.Student;
import in.yoy.resources.JavaConfigForAnno;
import in.yoy.resources.SpringConfigFile;

public class Main 
{
	public static void main(String[] args) 
	{
//		String path = "in/yoy/resources/ApplicationContext.xml" ;
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigForAnno.class) ;
		Employee emp = context.getBean("Majdoor", Employee.class) ;
//		Employee emp = context.getBean(Employee.class) ;
		System.out.println(emp.toString()); 
		context.close();
	}
}
