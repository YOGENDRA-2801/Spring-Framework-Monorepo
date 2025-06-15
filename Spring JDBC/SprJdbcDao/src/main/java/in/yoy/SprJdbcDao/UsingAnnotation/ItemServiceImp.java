package in.yoy.SprJdbcDao.UsingAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemServiceInterface {

	@Autowired
	private ItemDaoInterface itemDaoImp;

	public void setItemDaoImp(ItemDaoInterface itemDaoImp) {
		this.itemDaoImp = itemDaoImp;
	}

	public ItemServiceImp() {
		super();
	}

	public ItemServiceImp(ItemDaoInterface itemDaoImp) {
		super();
		this.itemDaoImp = itemDaoImp;
	}

	@Override
	public boolean addInsertion(StockBean itemBean) {
		boolean status = itemDaoImp.insertItemIntoDB(itemBean);
		return status;
	}
}