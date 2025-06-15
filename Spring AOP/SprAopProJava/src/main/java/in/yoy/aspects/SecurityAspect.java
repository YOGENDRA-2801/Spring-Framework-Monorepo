package in.yoy.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect 
{
	@Before("execution(* in.yoy.services.BankServices.*(..))")
	public void prathamsSuraksha() 
	{
		System.out.println("-----INITIAL-SECURITY-ADVICE-----");
	}
	
	@After("execution(* in.yoy.services.BankServices.*(..))")
	public void antimSuraksha() 
	{
		System.out.println("-----FINAL-SECURITY-ADVICE-----");
	}
	
//	EITHER USE BEFORE+AFTER OR USE AROUND (BETTER USE AROUND) 
	
	@Around("execution(* in.yoy.services.BankServices.*(..)) || execution(* in.yoy.services.PaytmServices.*(..))")
	public void suraksha(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("-----AROUND-INITIAL-SECURITY-ADVICE-----");
//		LOC before this will get executed like @Before
		pjp.proceed(); // Throws Throwable ; 
//		LOC after this will get executed like @After
		System.out.println("-----AROUND-FINAL-SECURITY-ADVICE-----");
	}
	
}
