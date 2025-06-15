package in.yoy.SprJdbcBasic.beans;

import java.math.BigDecimal;

public class Boutique 
{
	private int itemId ;
	private String itemName ;
	private BigDecimal itemPrice ;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public Boutique() {
		super();
	}
	public Boutique(int itemId, String itemName, BigDecimal itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public void display() {
		System.out.println("----- ITEM DETAILS -----");
		System.out.println("Item ID : " + itemId);
		System.out.println("Item Name : " + itemName);
		System.out.println("Item Price : " + itemPrice);
		System.out.println();
	}
	
}
