package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import in.yoy.beans.Address;
import in.yoy.beans.Department;
import in.yoy.beans.Earth;
import in.yoy.beans.Employee;
import in.yoy.beans.Moon;
import in.yoy.beans.Myself;
import in.yoy.beans.Student;

@Configuration
public class SpringConfigFile 
{
//	SETTER METHOD DI
	@Bean("pata")
	public Address crtAdd() {
		Address a1 = new Address();
		a1.setCity("Thane");
		a1.setHouseno(101);
		a1.setPincode(400610);
		return a1 ;
	}
	@Bean("stud")
	public Student crtStd() {
		Student s1 = new Student() ;
		s1.setName("Yogendra");
		s1.setRollno(34);
		s1.setAddress(crtAdd());
		return s1 ;
	}
	
//	CONSTRUCTOR DI
	@Bean("module")
	public Department crtdept() {
		Department d1 = new Department(99, "YOY", "Finance") ;
		return d1 ;
	}
	@Bean("majdoor")
	public Employee crtEmp() {
		Employee emp = new Employee(2851, "CA", crtdept()) ;
		return emp;
	}
	
//	MIX OF SETTER AND CONSTRUCTOR
	@Bean("insaan")
	public Myself crtIntro() {
		Myself m1 = new Myself("Yogendra", 22, crtAdd(), crtdept()) ;
		return m1;
	}
	
//	CURCULAR DI
	@Bean("kalagola")
	public Moon crtMoon(Earth earth) {
		Moon m1 = new Moon();
		m1.setPrithvi(earth);
		return m1;
	}
	@Bean("haragola")
	public Earth crtEarth(@Lazy Moon moon) {
		Earth e1 = new Earth() ;
		e1.setChaand(moon);
		return e1 ;
	}
}












