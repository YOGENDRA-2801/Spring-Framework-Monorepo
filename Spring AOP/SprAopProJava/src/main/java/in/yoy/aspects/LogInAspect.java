package in.yoy.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogInAspect 
{
	@Before("execution(* in.yoy.services.BankServices.*(..))")
	public void prawesh() {
		System.out.println("-----LOG-IN-ADVICE-----");
	}
	
	@After("execution(* in.yoy.services.BankServices.*(..))")
	public void nirgaman() {
		System.out.println("-----LOG-OUT-ADVICE-----");
	}
}
