package in.yoy.modularDaoService;

public class ItemServiceImp implements ItemServiceInterface {

	@Override
	public boolean addInsertion(StockBean itemBean) {
		ItemDao itemDaoImp = new ItemDaoImp();

		boolean status = itemDaoImp.insertItemIntoDB(itemBean);

		return status ;
	}
}