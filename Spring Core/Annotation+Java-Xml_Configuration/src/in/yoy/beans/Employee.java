package in.yoy.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("654123")
	private int salary ;
	@Value("7890")
	private int empcode ;
	@Value("Karamchari")
	private String designation ;
	
	public Employee() {
		super();
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", empcode=" + empcode + ", designation=" + designation + "]";
	}
	
	
	
}
