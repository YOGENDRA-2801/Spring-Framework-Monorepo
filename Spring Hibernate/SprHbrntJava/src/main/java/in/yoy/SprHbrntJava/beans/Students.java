package in.yoy.SprHbrntJava.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_rollno")
	private int rollno;
	@Column(name = "std_name")
	private String name;
	@Column(name = "std_course")
	private String course;
	@Column(name = "std_marks", precision = 10, scale = 2)
	private BigDecimal marks;

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

	public BigDecimal getMarks() {
		return marks;
	}

	public void setMarks(BigDecimal marks) {
		this.marks = marks;
	}

	public Students() {
		super();
	}
	
	public Students(String name, String course, BigDecimal marks) {
		super();
		this.name = name;
		this.course = course;
		this.marks = marks;
	}

	public Students(int rollno, String name, String course, BigDecimal marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	
	public void display() {
		System.out.println(" ----- STUDENT DETAILS ----- ");
		System.out.println("NAME : " + name);
		System.out.println("ROLL NO : " + rollno);
		System.out.println("COURSE : " + course);
		System.out.println("MARKS : " + marks);
		System.out.println();
	}
}
