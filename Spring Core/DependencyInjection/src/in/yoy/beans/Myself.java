package in.yoy.beans;

public class Myself 
{
	
	private String name ;
	private int age ;
	private Address add ;
	private Department dept ;
	
	public Myself() {
		super();
	}
	
	public Myself(String name, int age, Address add, Department dept) {
		super();
		this.name = name;
		this.age = age;
		this.add = add;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Myself [name=" + name + ", age=" + age + ", add=" + add + ", dept=" + dept + "]";
	}

}
