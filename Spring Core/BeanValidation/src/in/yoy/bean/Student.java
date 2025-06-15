package in.yoy.bean;

public class Student 
{
	private int rollno ;
	private String name ;
	private String phonenumber ;
	
	// Phone No Bada hota hai hence int m nahi rkhne ka keep it in long or String
	// Phone No k liye String preferred hai bcoz jada operation nahi hote phone number pr
	
	public Student() {
		super();
	}	
	
	public Student(int rollno, String name, String phonenumber) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.phonenumber = phonenumber;
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	} 
	
	public void display() {
		System.out.printf("Name of Student is %s has roll number %d and his phone number is %s" , name , rollno , phonenumber);
	}
	
}
