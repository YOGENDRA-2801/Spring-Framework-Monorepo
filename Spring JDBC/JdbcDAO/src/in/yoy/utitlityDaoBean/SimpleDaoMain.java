package in.yoy.utitlityDaoBean;

import java.math.BigDecimal;

public class SimpleDaoMain {
	public static void main(String[] args) {
		
		ItemBean itemBean = new ItemBean(4, "Hoodie", new BigDecimal(543.21));
		ItemDao itemDaoImp = new ItemDaoImp();
		
		boolean status = itemDaoImp.insertItem(itemBean.getItemId() , itemBean.getName() , itemBean.getPrice()) ;
		
		if (status) {
			System.out.println("INSERTED SUCCESSFULLY");
		}
		else {
			System.out.println("INSERTION FAILED");
		}
		
	}
}
