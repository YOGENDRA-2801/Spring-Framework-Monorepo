package in.yoy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.beans.Address;
import in.yoy.beans.Department;
import in.yoy.beans.Earth;
import in.yoy.beans.Employee;
import in.yoy.beans.Moon;
import in.yoy.beans.Myself;
import in.yoy.beans.Student;
import in.yoy.resources.SpringConfigFile;

public class Main 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
//		SETTER METHOD DI
//		Address add = context.getBean("pata", Address.class);
//		System.out.println(add);		
//		Student std = context.getBean("stud", Student.class);
//		System.out.println(std);
		
//		CONTRUCTOR ARG DI
//		Department dept = context.getBean("module", Department.class) ;
//		System.out.println(dept);
//		Employee emp = context.getBean("majdoor", Employee.class) ;
//		System.out.println(emp);
		
//		MIX OF SETTER AND CONSTRUCTOR
//		Myself me = context.getBean("insaan", Myself.class) ;
//		System.out.println(me);
		
//		CIRCULAR DI
		Earth e1 = context.getBean("haragola", Earth.class) ;
		e1.display();		
		Moon m1 = context.getBean("kalagola", Moon.class) ;	
		m1.display();
		
		context.close();
	}
}

// XML BASED CONFIGURATION

//AbstractApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/resources/applicationontext.xml");

//SETTER METHOD DI
//Address add = context.getBean("pata", Address.class);
//System.out.println(add);		
//Student std = context.getBean("vidyarthi", Student.class);
//System.out.println(std);

//CONTRUCTOR ARG DI
//Department dept = context.getBean("module", Department.class) ;
//System.out.println(dept);		
//Employee emp = context.getBean("majdoor", Employee.class) ;
//System.out.println(emp);

//MIX OF SETTER AND CONSTRUCTOR
//Myself me = context.getBean("insaan", Myself.class) ;
//System.out.println(me);

//CIRCULAR DI
//Earth e1 = context.getBean("haragola", Earth.class) ;
//e1.display();		
//Moon m1 = context.getBean("kalagola", Moon.class) ;	
//m1.display();

//context.close();
