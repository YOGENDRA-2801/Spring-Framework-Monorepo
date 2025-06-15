package in.yoy.SprJdbcDao.UsingNmdParamDaoSprt;

import java.math.BigDecimal;

public class StockBean {
	private int itemId;
	private String itemName;
	private BigDecimal itemPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return itemName;
	}

	public void setName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return itemPrice;
	}

	public void setPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public StockBean() {
		super();
	}

	public StockBean(int itemId, String itemName, BigDecimal itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public void display() {
		System.out.println("ITEM ID : " + itemId);
		System.out.println("ITEM NAME : " + itemName);
		System.out.println("ITEM PRICE : " + itemPrice);
		System.out.println("=========================");
	}

}
