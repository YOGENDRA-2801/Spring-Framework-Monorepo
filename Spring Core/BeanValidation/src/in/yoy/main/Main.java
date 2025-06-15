package in.yoy.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.DataBinder;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import in.yoy.bean.Student;
import in.yoy.resources.SpringConfigFile;
import in.yoy.validator.StudentValidator;

public class Main 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/resources/ApplicationContext.xml");
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		Student stud = context.getBean("vidyarthi", Student.class);
		StudentValidator stdval = context.getBean("stdval", StudentValidator.class) ; // for BindingResult
		
//		----- DataBinder -----

		DataBinder db = new DataBinder(stud) ; // object ko bind kiya
		db.addValidators( stdval ) ; // Validator add kiya
//		db.addValidators( new StudentValidator() ) ; // it's manual obj crt hence spr will init the obj automatically
//StudentValidator ko manually crt kiya & manual init nahi kiya obj aur prop ko hence uss class ki prop null hi rh jayegi
		db.validate(); // validate method ko call kiya
		List<ObjectError> l1 = db.getBindingResult().getAllErrors(); // saare errors get kiye
		
//		----- BindingResult using MapBindingResut -----
/*
		Map<String, Object> naksha = new HashMap<String, Object>() ; // Map crt becoz MBR k constructor k args m need h
//		validation process ke dauran, error messages ya details ko identify karne ke liye property names ka string hona zaruri 
//		hai, aur unki values alag-alag types ki ho sakti hain esiliye object use kiya.
		MapBindingResult mpr = new MapBindingResult(naksha, "kuchBhiNaamChalega") ; // "kuchBhiNaamChalega" refer the following
//		Iska kaam hai object ko identify karna jispar binding ho rahi hai. Internal working k liye zaruri hai.
//		It's an mandatory paramete.  Framework ke internal workings ya error message resolution me yeh naam use ho sakta hai.
//		validation errors report karte time error messages me yeh naam include ho sakta hai. 
		stdval.supports(stud.getClass()); // explicitly called hence kuch action nahi krga when false raised unless hardcoded
		stdval.validate(stud, mpr);
		List<ObjectError> l1 = mpr.getAllErrors();
*/	
		
		if (l1.isEmpty()) {
			stud.display() ;
		}
		else {
			for (ObjectError objectError : l1) {
				System.out.println(objectError); // wah specific error related saari chize print karege
				System.out.println("---------------");
				System.out.println(objectError.getDefaultMessage()); // hamara likha hua error print karega
			}
		}
		
		context.close();
	}
}
