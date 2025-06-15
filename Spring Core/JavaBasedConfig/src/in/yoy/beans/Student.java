package in.yoy.beans;

public class Student {
	
	private int rollno ;
	private String naam ;
	private boolean dead ;
	
	public Student() {
		super();
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", naam=" + naam + ", dead=" + dead + "]";
	}	
	
}
