package in.yoy.SprJdbcDao.UsingAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class UsingAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

		StockBean item = context.getBean("itemBean", StockBean.class);
		ItemServiceInterface itemServiceImp = context.getBean("itemServiceImp", ItemServiceImp.class);

		boolean status = itemServiceImp.addInsertion(item);
		if (status)
			System.out.println("INSERTION COMPLETED");
		else
			System.out.println("INSERTION FAILED");

		context.close();
	}
}