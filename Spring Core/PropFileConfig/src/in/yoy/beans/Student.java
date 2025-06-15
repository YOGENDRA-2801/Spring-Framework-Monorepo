package in.yoy.beans;

import java.util.List;
import java.util.Map;

public class Student 
{
	private String name;
	private int rollNo;
	private String course;
	private List<String> subjects ;
	private Map<String, Double> marks ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Map<String, Double> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Double> marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", course=" + course + ", subjects=" + subjects
				+ ", marks=" + marks + "]";
	}
	
}
