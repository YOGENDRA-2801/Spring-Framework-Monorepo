package in.yoy.beans;

public class Students 
{
	private int rollno ;
	private String name ;
	private String course ;
	
	public Students() {
		super();
	}
	
	public Students(int rollno, String name, String course) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.course = course;
	}

	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public void display () {
//		System.out.println("Name : " + getName() + " with roll no. : " + getName() + " has completed his study in : " + getCourse() );
		System.out.println("Name : " + this.name + " with roll no. : " + this.rollno + " has completed his study in : " + this.course );
	}

	@Override
	public String toString() {
		return "Students [rollno=" + rollno + ", name=" + name + ", course=" + course + "]";
	}
	
}
