package in.yoy.beans;

public class Employee 
{
	
	private int empcode ;
	private String designation ;
	private Department department ;
	
	public Employee() {
		super();
	}

	public Employee(int empcode, String designation, Department department) {
		super();
		this.empcode = empcode;
		this.designation = designation;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", designation=" + designation + ", department=" + department + "]";
	}

}
