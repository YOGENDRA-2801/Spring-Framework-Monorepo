package in.yoy.SprJdbcDao.UsingJdbcDaoSupport;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ItemDaoImp extends JdbcDaoSupport implements ItemDaoInterface {

	@Override
	public boolean insertItemIntoDB(StockBean bean) {
		String sqlcmdString = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;";
		Object object[] = { bean.getItemId(), bean.getName(), bean.getPrice() };
		int count = getJdbcTemplate().update(sqlcmdString, object);
		if (count > 0)
			return true;
		else
			return false;
	}

}
