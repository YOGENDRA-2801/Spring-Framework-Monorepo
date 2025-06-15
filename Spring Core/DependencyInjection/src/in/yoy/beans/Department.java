package in.yoy.beans;

public class Department 
{
	
	private int strength ;
	private String hod ;
	private String deptname ;
	
	public Department() {
		super();
	}

	public Department(int strength, String hod, String deptname) {
		super();
		this.strength = strength;
		this.hod = hod;
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Department [strength=" + strength + ", hod=" + hod + ", deptname=" + deptname + "]";
	}

}
