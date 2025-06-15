package in.yoy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.beans.Employee;
import in.yoy.beans.Student;
import in.yoy.resources.SpringConfigFile;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
		Employee e = (Employee)context.getBean("emp1");
		System.out.println(e);
		
		Employee e2 = (Employee)context.getBean("majdoor");
		System.out.println(e2);
		
		Employee e3 = (Employee)context.getBean("majboori");
		System.out.println(e3);
		
		Student s = (Student)context.getBean("stud1");
		System.out.println(s);
		
		((AbstractApplicationContext) context).close() ;
	}
}
