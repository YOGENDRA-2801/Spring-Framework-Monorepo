package in.yoy.SprJdbcDao.UsingNmdParamDaoSprt;

import java.util.Map;

public class ItemServiceImp implements ItemServiceInterface {

	private ItemDaoInterface itemDaoImp;

	public void setItemDaoImp(ItemDaoInterface itemDaoImp) {
		this.itemDaoImp = itemDaoImp;
	}

	@Override
	public boolean addInsertion(Map<String, Object> map) {
		boolean status = itemDaoImp.insertItemIntoDB(map);
		return status;
	}
}