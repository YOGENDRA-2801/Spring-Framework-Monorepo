package in.yoy.JpaProCRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int id;
	@Column(name = "dept_name")
	private String name;
	@Column(name = "dept_strength")
	private int strength;
	@Column(name = "dept_head")
	private String head;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Department() {
		super();
	}
	
	public Department(String name, int strength, String head) {
		super();
		this.name = name;
		this.strength = strength;
		this.head = head;
	}

	public Department(int id, String name, int strength, String head) {
		super();
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.head = head;
	}

	public void display() {
		System.out.println(" ----- DEPARTMENT DETAILS ----- ");
		System.out.println("NAME : " + name);
		System.out.println("ID : " + id);
		System.out.println("STRENGTH : " + strength);
		System.out.println("HEAD : " + head);
		System.out.println();
	}
}
