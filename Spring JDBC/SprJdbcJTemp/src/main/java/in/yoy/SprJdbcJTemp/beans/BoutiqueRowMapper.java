package in.yoy.SprJdbcJTemp.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoutiqueRowMapper implements RowMapper<Boutique>
{
	@Override
	public Boutique mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
//		Yh meth ek ek krke hr row me jata hai and given column name ka data ka utha ki obj m store krta hai than 
//		wah row complete hone ke baad yh method caller ko wah object de deta hai return krta
		Boutique item = new Boutique() ;
		item.setItemId(rs.getInt("item_id")); // name should be same as column name
		item.setItemName(rs.getString("item_name"));
		item.setItemPrice(rs.getBigDecimal("item_price"));
		return item;
	}
}
