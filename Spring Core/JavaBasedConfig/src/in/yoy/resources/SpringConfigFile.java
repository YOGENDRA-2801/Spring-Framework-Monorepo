package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.yoy.beans.Employee;
import in.yoy.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Employee emp1() {
		Employee e1 = new Employee() ;
		e1.setDesignationString("Network Security Engineer");
		e1.setEmpcode(82);
		e1.setSalary(25000);
		return e1 ;
	}
	
	@Bean (name = {"majdoor" , "majboori"}) // spaces and semicolon NOT allowed for separation
	public Employee emp2() {
		Employee e1 = new Employee() ;
		e1.setDesignationString("Chaukidaar");
		e1.setEmpcode(2851);
		e1.setSalary(13957);
		return e1 ;
	}
	
	@Bean(name = "stud1") // id attribute does not exists in @bean
	public Student std1() {
		Student stud = new Student() ;
		stud.setDead(false);
		stud.setNaam("Yogendra Yadav");
		stud.setRollno(57);
		return stud ;
	}
	
}
