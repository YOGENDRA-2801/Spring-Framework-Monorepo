package in.yoy.beans;

public class Employee {
	
	private String designationString ;
	private int empcode ;
	private float salary ;
	
	public Employee() {
		super();
	}

	public String getDesignationString() {
		return designationString;
	}
	public void setDesignationString(String designationString) {
		this.designationString = designationString;
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
		return "Employee [designationString=" + designationString + ", empcode=" + empcode + ", salary=" + salary + "]";
	}	
	
}
