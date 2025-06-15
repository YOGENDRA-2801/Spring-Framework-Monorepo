package in.yoy.SprJdbcDao.DirectApproach;

public class ItemServiceImp implements ItemServiceInterface {

	private ItemDaoInterface itemDaoImp;

	public void setItemDaoImp(ItemDaoInterface itemDaoImp) {
		this.itemDaoImp = itemDaoImp;
	}

	@Override
	public boolean addInsertion(StockBean itemBean) {
		boolean status = itemDaoImp.insertItemIntoDB(itemBean);
		return status;
	}
}