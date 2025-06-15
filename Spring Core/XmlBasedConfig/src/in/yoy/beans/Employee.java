package in.yoy.beans;

public class Employee {
	
	private String designation ;
	private int empcode ;
	private float salary ;
	
	public Employee() {
		super();
	}
	
	
	public Employee(String designation, int empcode, float salary) {
		super();
		this.designation = designation;
		this.empcode = empcode;
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [designation=" + designation + ", empcode=" + empcode + ", salary=" + salary + "]";
	}

}
