package in.yoy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.ApplicationContext;

import in.yoy.beans.Student;

public class Main {
	
	public static void main(String[] args) {
		
//		System.out.println("First Way");
//		ApplicationContext context = new AnnotationConfigApplicationContext(Student.class) ; 
		
//		System.out.println("Second Way");
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Student.class) ;
		
		System.out.println("Third Way");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext() ;
		context.register(Student.class);
		context.refresh();
		
//		Student stud = (Student) context.getBean("student") ; //  when name is not mentioned explicitly
		Student stud = (Student) context.getBean("Vidyarthi") ;
		System.out.println(stud.toString()); 
		
//		context.close();
		((AbstractApplicationContext) context).close() ;
		
	}

}
