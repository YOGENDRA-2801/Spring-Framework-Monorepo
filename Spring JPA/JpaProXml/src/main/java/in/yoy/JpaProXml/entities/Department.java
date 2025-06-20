package in.yoy.JpaProXml.entities;

public class Department {
	private int id;
	private String name;
	private int strength;
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
