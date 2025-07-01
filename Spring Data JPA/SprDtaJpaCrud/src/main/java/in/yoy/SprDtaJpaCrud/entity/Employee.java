package in.yoy.SprDtaJpaCrud.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_desi")
	private String designation;
	@Column(name = "emp_sala" , precision = 10 , scale = 2 )
	private BigDecimal salary;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(String name, String designation, BigDecimal salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public Employee(int id, String name, String designation, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public void display() {
		System.out.println(" ----- EMPLOYEE DETAIL ----- ");
		System.out.println("NAME : " + name);
		System.out.println("ID : " + id);
		System.out.println("DESIGNATION : " + designation);
		System.out.println("SALARY : " + salary);
		System.out.println();
	}

}