package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import in.yoy.aspects.LogInAspect;
import in.yoy.aspects.SecurityAspect;
import in.yoy.aspects.TerminateAspect;
import in.yoy.services.BankServices;
import in.yoy.services.PaytmServices;

@Configuration
@EnableAspectJAutoProxy
public class JavaSpringConfig 
{
	@Bean("bnkSrv")
	public BankServices bnkSrv() {
		return new BankServices() ;
	}
	
	@Bean("pytmSrv")
	public PaytmServices pytmSrv() {
		return new PaytmServices() ;
	}
	
	@Bean("terminateAspect")
	public TerminateAspect terminateAspect() {
		return new TerminateAspect() ;
	}
	
	@Bean("logInAspect")
	public LogInAspect logInAspect() {
		return new LogInAspect() ;
	}
	
	@Bean("securityAspect")
	public SecurityAspect securityAspect() {
		return new SecurityAspect() ;
	}
	
	
	
}
