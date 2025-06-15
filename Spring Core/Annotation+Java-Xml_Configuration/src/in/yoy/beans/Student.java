package in.yoy.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("abcd")
@Component("Vidyarthi")
public class Student {
	
	@Value("Yogendra")
	private String naam ;
//	@Value("karamchari")
	private String course ;
	@Value("56")
	private int rollno ;
	
	public Student() {
		super();
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Student [naam=" + naam + ", course=" + course + ", rollno=" + rollno + "]";
	}
	
}
