package in.yoy.SprJdbcDao.UsingNmdParamDaoSprt;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class ItemDaoImp extends NamedParameterJdbcDaoSupport implements ItemDaoInterface {

	@Override
	public boolean insertItemIntoDB(Map<String, Object> map) {
		String sqlcmdString = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (:key_id , :key_name , :key_price) ;";
		int count = getNamedParameterJdbcTemplate().update(sqlcmdString, map);
		if (count > 0)
			return true;
		else
			return false;
	}

}
