package in.yoy.beans;

public class Student {
	
	private int rollno ;
	private String name ;
	private String course ;
	
	public Student() {
		super();
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
	
//	@Override
//	public String toString() {
//		return "Student [rollno=" + rollno + ", name=" + name + ", course=" + course + "]";
//	}
	
}
