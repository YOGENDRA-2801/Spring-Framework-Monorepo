package in.yoy.beans;

public class Earth 
{
	
	private Moon chaand ;
	
//	public Earth() {
//		super();
//	}
////  KUCH FAYEDA NAHI HUA
//	
//	public Earth(Moon chaand) {
//		super();
//		this.chaand = chaand;
//	}
	
	public Moon getChaand() {
		return chaand;
	}
	public void setChaand(Moon chaand) {
		this.chaand = chaand;
	}

//	@Override
//	public String toString() {
//		return "Earth [chaand=" + chaand + "]";
//	}
// WILL THROW STACKOVERFLOW EXCEPTION
//	this Earth's toString() is printing chaand reference which internally calls Moon's toString() and that again internally call Earth's toString() ...
	
	public void display() {
		System.out.println("Earth ke ander reference iska hai -> " + chaand.getClass().getSimpleName() + " " + chaand );
	}

}
