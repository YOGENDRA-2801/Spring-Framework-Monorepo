package in.yoy.SprJdbcJTemp.main;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.yoy.SprJdbcJTemp.beans.Boutique;
import in.yoy.SprJdbcJTemp.beans.BoutiqueRowMapper;
import in.yoy.SprJdbcJTemp.resources.SpringConfigFile;

public class Select 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
		
		JdbcTemplate jtemp = context.getBean("jTemplate", JdbcTemplate.class);
		BoutiqueRowMapper itmrwmpr = context.getBean("itmrwmpr", BoutiqueRowMapper.class);
		
//		SIMPLE SELECT STATEMENT
//		String selectCmd1 = "SELECT * FROM boutique ;" ;
//		List<Boutique> crntrow = jtemp.query(selectCmd1, itmrwmpr);
//		for (Boutique boutique : crntrow) {
//			boutique.display();
//		}
		
//		SELECT WITH POSITINAL PARAM + USING LIST
//		int id1 = 101 ; int id2 = 103 ;
//		String selectCmd1 = "SELECT * FROM boutique WHERE item_id=? OR item_id=? ;" ;
//		List<Boutique> crntrow = jtemp.query(selectCmd1, itmrwmpr, id1 , id2);
//		for (Boutique boutique : crntrow) {
//			boutique.display();
//		}
		
//		SELECT IN CASE FOR FETCHING SINGLE OBJECT (single obj h to list ki need nahi & use queryForObject)
//		int id1 = 101 ;
//		String selectCmd1 = "SELECT * FROM boutique WHERE item_id=? ;" ;
//		Boutique crntrow = jtemp.queryForObject(selectCmd1, itmrwmpr, id1);
//		crntrow.display();
		
//		USING MAP FOR SIMPLE SELECT CMD
		int id1 = 101 ; 
		String selectCmd1 = "SELECT * FROM boutique WHERE item_id=? ;" ;
		Map<String, Object> crntrow = jtemp.queryForMap(selectCmd1, id1);
		System.out.println(crntrow);
		
		context.close();
	}
}
