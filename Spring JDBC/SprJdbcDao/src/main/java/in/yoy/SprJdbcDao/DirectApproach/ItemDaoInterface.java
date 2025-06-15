package in.yoy.SprJdbcDao.DirectApproach;


public interface ItemDaoInterface {
	
//	VARIABLES IN INTERFACE 
//		1. ALWAYS PUBLIC FINAL STATIC
//		2. MUST BE INITIALIZED
//		3. ACTS LIKE A CONSTANT
//		4. IT IS IMPLICITLY TREATED AS 
//			PUBLIC STATIC FINAL INT X = 19 ;
	
	public boolean insertItemIntoDB(StockBean bean);
}
