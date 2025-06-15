package in.yoy.modularDaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoImp implements ItemDao {

	@Override
	public boolean insertItemIntoDB(StockBean bean) {
		try (Connection connection = DBUtility.getConnection();) {
			String sqlCmdString = "INSERT INTO boutique (item_id,item_name,item_price) VALUES (?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sqlCmdString) ;
			ps.setInt(1, bean.getItemId()) ;
			ps.setString(2, bean.getName()) ;
			ps.setBigDecimal(3, bean.getPrice()) ;
			int count = ps.executeUpdate() ;
			if (count>0) {
				return true ;
			}
			else {
				return false ;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}		
	}

}
