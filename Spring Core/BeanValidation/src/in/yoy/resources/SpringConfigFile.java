package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.yoy.bean.Student;

@Configuration
public class SpringConfigFile 
{
	@Bean("vidyarthi")
	public Student stud() {
		Student std1 = new Student(101, "Tom Cruise", "9876543210") ;
		return std1 ;
	}
}
