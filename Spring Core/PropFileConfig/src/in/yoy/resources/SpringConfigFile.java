package in.yoy.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import in.yoy.beans.Student;

//@PropertySource("classpath:in/yoy/resources/student.properties")  
//Classpath-safe, har type ki app me (Standalone/Web/Microservice) consistent, JAR/WAR/Docker sab me work karega

//@PropertySource("in/yoy/resources/student.properties")  
//Servlet context pe depend karta hai, Standalone & Enterprise apps me unreliable, path issues aate hain

@Configuration
@PropertySource("classpath:in/yoy/resources/student.properties") 
public class SpringConfigFile  {
	
	@Value("${student.subjects.s3}")
	private String sub3;
	
	@Value("${student.marks.k1}")
	private String fir_yr_sub ;
	
	@Value("${student.marks.v2}")
	private double sec_yr_mrk ;
	
	@Bean("vidyarthi")
	public Student crtStudent() {
		Student s1 = new Student() ;
		s1.setName("Tony Stark");
		s1.setRollNo(55);
		s1.setCourse("BTECH");
		
		List<String> stud = new ArrayList<String>();
		stud.add("C");
		stud.add("Cpp");
		stud.add(sub3);
		stud.add("Python");
		s1.setSubjects(stud);
		
		Map<String, Double> ankhMap = new HashMap<String, Double>() ;
		ankhMap.put(fir_yr_sub, 147d) ;
		ankhMap.put("SY", sec_yr_mrk) ;
		ankhMap.put("TY", 369d) ;
		s1.setMarks(ankhMap);
		
		return s1 ;
	}
}
