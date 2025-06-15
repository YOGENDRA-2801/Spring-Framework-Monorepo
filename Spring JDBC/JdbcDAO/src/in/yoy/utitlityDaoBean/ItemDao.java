package in.yoy.utitlityDaoBean;

import java.math.BigDecimal;

public interface ItemDao {
	public boolean insertItem(int id , String name , BigDecimal price);
}
