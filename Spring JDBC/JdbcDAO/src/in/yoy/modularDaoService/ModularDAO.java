package in.yoy.modularDaoService;

import java.math.BigDecimal;

public class ModularDAO 
{
	public static void main(String[] args) 
	{
//		DAO TO WRITE DATABASE OPERATION 
//		SERVICE TO USE THE DB OPERATION FROM DAO [bus implementation call karega]
//		MAIN TO JUST USE THE RESULT FROM SERVICE
		
		StockBean itemBean = new StockBean(4, "Hoodie", new BigDecimal(543.21));
		
		ItemServiceInterface itemServiceImp = new ItemServiceImp() ;
		boolean status = itemServiceImp.addInsertion(itemBean);
		
		if (status) {
			System.out.println("INSERTED SUCCESSFULLY");
		}
		else {
			System.out.println("INSERTION FAILED");
		}
	}
}
