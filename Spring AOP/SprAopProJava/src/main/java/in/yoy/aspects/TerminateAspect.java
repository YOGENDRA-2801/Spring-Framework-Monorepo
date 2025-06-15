package in.yoy.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TerminateAspect 
{
	@After("execution(* in.yoy.services.BankServices.net(..)) || execution(* in.yoy.services.BankServices.mob(..))")
//	@AfterReturning("execution(* in.yoy.services.BankServices.net(..)) || " + 
//			"execution(* in.yoy.services.BankServices.mob(..))")
	public void cnctnClsd() 
	{
		System.out.println("-----CLOSE RESOURCES ADVICE-----");
	}
}
