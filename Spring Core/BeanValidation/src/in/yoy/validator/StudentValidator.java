package in.yoy.validator;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.yoy.bean.Student;

public class StudentValidator implements Validator 
{
	
	private Resource res ; // Use of resource instead of FileInputStream is preferreds
	
	public Resource getRes() {
		return res;
	}
	public void setRes(Resource res) {
		this.res = res;
	}

	@Override
	public boolean supports(Class<?> clazz) {
//		Class<?> mein jo ? use hua hai, uska matlab hai "unknown type" ya "wildcard."
//		It's a part of generic syntax that tells ess method parameter ke roop mein koi bhi class type pass ki ja sakti hai, 
//		bina specific type ko enforce kiye.
		
		boolean b = Student.class.equals(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		try 
		{
			Student stud = (Student) target ; // args(target) s stud ka obj mil jayega (crt krne ki need nhi)
			
			Properties prop = PropertiesLoaderUtils.loadProperties(res); // This can raise IOE 
			
			if (stud.getRollno() < 0) {
				errors.rejectValue("rollno", "key_rollno", prop.getProperty("key_rollno") );
			}
			
			if (stud.getPhonenumber().length() != 10) {
				errors.rejectValue("phonenumber", "key_phone", prop.getProperty("key_phone") );
			}
			
	//		^ and $: Ensure the pattern matches the entire string.
	//		{2,50}: Length between 2 and 50 characters (you can adjust it)
	//		[A-Za-z\\s]: Allows uppercase (A-Z), lowercase (a-z), and spaces (\\s)
			if (!stud.getName().matches("^[A-Za-z\\s]{2,50}$")) {
				errors.rejectValue("name", "key_name", prop.getProperty("key_name"));
		}
		
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
	}
	
}
