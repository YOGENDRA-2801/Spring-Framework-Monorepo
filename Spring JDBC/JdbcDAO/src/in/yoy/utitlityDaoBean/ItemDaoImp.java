package in.yoy.utitlityDaoBean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoImp implements ItemDao {

	@Override
	public boolean insertItem(int id, String name, BigDecimal price) {
		try (Connection connection = DBUtility.getConnection();) {
			String sqlCmdString = "INSERT INTO boutique (item_id,item_name,item_price) VALUES (?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sqlCmdString) ;
			ps.setInt(1, id) ;
			ps.setString(2, name) ;
			ps.setBigDecimal(3, price) ;
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
