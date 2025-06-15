package in.yoy.beans;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("Majdoor")
public class Employee 
{
	@Value("2851")
	private int emp_id;
	
	@Value("${beans.employee.name}")
	private String name ;
	
	@Value("123456")
	private double salary ;
		
	@Value ("#{ { ${employee.techstack.core}:3, 'Spring': ${employee.experience.v2}, 'Python':2} }")
	private Map<String, Integer> experience ;
		
	@Value("Angular , ${beans.employee.techstack.db} , Spring Boot")
	private List<String> techstack ;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Map<String, Integer> getExperience() {
		return experience;
	}
	public void setExperience(Map<String, Integer> experience) {
		this.experience = experience;
	}
	public List<String> getTechstack() {
		return techstack;
	}
	public void setTechstack(List<String> techstack) {
		this.techstack = techstack;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", experience=" + experience
				+ ", techstack=" + techstack + "]";
	}
	
}

//Property values ke andar ':' nahi ho sakta — wo SpEL ke Map syntax ka part hota hai

//Kya poora Map ek hi property se inject ho sakta hai? NO
//employee.experience=Java:3,Spring:5,Python:2
//@Value("#{ '${employee.experience}' }")  // ye nahi chalega
//Nahi chalega — kyunki: ${employee.experience} resolve ho ke ek String ban jaata hai and SpEL me Map literal chahiye, not plain String

//Ager Poora Map Inject krna hai to Manual Parsing krna padega in Spring Core (Boot m easily hota h)

