package in.yoy.SprJdbcBatch.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcBatch.beans.Items;
import in.yoy.SprJdbcBatch.resources.SpringConfigFile;

public class UsingParamAndBean {
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		JdbcTemplate jdbcTemplate = context.getBean("JdbcTemplate", JdbcTemplate.class);
		Items firstItem = context.getBean("firstItem", Items.class);
		Items secondItem = context.getBean("secondItem", Items.class);
		Items thirdItem = context.getBean("thirdItem", Items.class);

		List<Items> stockItems = new ArrayList<Items>();
		stockItems.add(firstItem);
		stockItems.add(secondItem);
		stockItems.add(thirdItem);

		String sqlCmd = "INSERT INTO boutique (item_id, item_name, item_price) VALUES (? , ? , ?) ;";
		int[] count = jdbcTemplate.batchUpdate(sqlCmd, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Items item = stockItems.get(i);
				ps.setInt(1, item.getItemId());
				ps.setString(2, item.getItemName());
				ps.setBigDecimal(3, item.getItemPrice());
			}

			@Override
			public int getBatchSize() {
				return stockItems.size();
			}

		}

		);

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				System.out.println("SUCCESS");
			} else {
				System.out.println("FAILED");
			}
		}

		context.close();
	}
}
