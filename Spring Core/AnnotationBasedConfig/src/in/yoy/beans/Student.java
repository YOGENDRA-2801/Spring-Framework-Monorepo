package in.yoy.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Vidyarthi")
public class Student {

	@Value("28")
	private int rollno;
	@Value("YOY")
	private String name;
	@Value("BSCIT")
	private String course;

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

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", course=" + course + "]";
	}

}
