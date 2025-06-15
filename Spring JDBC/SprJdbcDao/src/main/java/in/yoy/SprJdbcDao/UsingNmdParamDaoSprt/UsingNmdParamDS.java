package in.yoy.SprJdbcDao.UsingNmdParamDaoSprt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

// IMPORT STATEMENT PR DHYAN DENA AS SAME NAMED CLASSES PRESENT HAI IN DIFFERENT PACKAGE OF SAME PROJECT
public class UsingNmdParamDS {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

		StockBean item = context.getBean("itemBean", StockBean.class);
		ItemServiceInterface itemServiceImp = context.getBean("itemServiceImp", ItemServiceImp.class);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key_id", item.getItemId());
		map.put("key_name", item.getName());
		map.put("key_price", item.getPrice());

		boolean status = itemServiceImp.addInsertion(map);
		if (status)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");

		context.close();
	}
}
