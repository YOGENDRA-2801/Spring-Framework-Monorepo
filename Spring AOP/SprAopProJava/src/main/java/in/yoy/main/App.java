package in.yoy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.resources.JavaSpringConfig;
import in.yoy.services.BankServices;
import in.yoy.services.PaytmServices;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaSpringConfig.class) ;
        
        BankServices bs = context.getBean("bnkSrv", BankServices.class) ;
        bs.upi(); System.out.println();
        bs.mob(); System.out.println();
        bs.net(); System.out.println();
        
        PaytmServices ps = context.getBean("pytmSrv", PaytmServices.class);
        ps.wallet(); System.out.println();
        
        context.close();
    }
}
