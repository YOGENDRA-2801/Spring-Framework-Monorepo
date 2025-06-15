package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.yoy.beans.Student;

@Configuration
@ComponentScan(basePackages = {"in.yoy.beans"})
public class SpringConfigFile {
	
	@Bean(name = "Vidyarthi") // if names are different/same here and beans class (Student.java) then bean class name will be preferred (hence value mentioned in @value will get preference) and this will be ignored
	public Student stud() {
		Student s1 = new Student() ;
		s1.setCourse("BSCIT"); // will only get used when course value is not mentioned (not even empty string) using @value and the getBean() has same argument as this bean name
		return s1 ;
	}
	
	@Bean(name = "graduate") // will not gonn'a get used even if explicitly name is mentioned in getBean() argument
	public Student s2() {
		Student s1 = new Student() ;
		s1.setNaam("SRS");
		s1.setRollno(1);
		s1.setCourse("pharma"); // will only get used when course value is not mentioned (not even empty string) using @value and the getBean() has same argument as this bean name 
		return s1 ;
	}

}