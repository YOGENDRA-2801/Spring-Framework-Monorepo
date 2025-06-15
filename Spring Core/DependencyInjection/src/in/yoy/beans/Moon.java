package in.yoy.beans;

public class Moon {
	
	private Earth prithvi ;
	
//	public Moon() {
//		super();
//	}
////	KUCH FAYEDA NAHI HUA
//
//	public Moon(Earth prithvi) {
//		super();
//		this.prithvi = prithvi;
//	}

	public Earth getPrithvi() {
		return prithvi;
	}
	public void setPrithvi(Earth prithvi) {
		this.prithvi = prithvi;
	}

//	@Override
//	public String toString() {
//		return "Moon [prithvi=" + prithvi + "]";
//	}
// WILL THROW STACKOVERFLOW EXCEPTION
// this Moon's toString() is printing prithvi reference which internally calls Earth's toString() and that again internally call Moon's toString() ...
	
	public void display() {
		System.out.println("Moon ke ander reference iska hai -> "  + prithvi.getClass().getSimpleName() + " " + prithvi );
	}

}
