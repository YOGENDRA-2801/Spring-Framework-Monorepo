package in.yoy.SprJdbcDao.UsingAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImp implements ItemDaoInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ItemDaoImp() {
		super();
	}

	public ItemDaoImp(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean insertItemIntoDB(StockBean bean) {
		String sqlcmdString = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;";
		Object object[] = { bean.getItemId(), bean.getName(), bean.getPrice() };
		int count = jdbcTemplate.update(sqlcmdString, object);
		if (count > 0)
			return true;
		else
			return false;
	}

}
