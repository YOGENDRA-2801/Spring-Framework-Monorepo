package in.yoy.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.services.BankServices;
import in.yoy.services.PaytmServices;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/resources/ApplicationContextOne.xml");
        
        BankServices bs = context.getBean("bnkSrv", BankServices.class) ;
        bs.upi(); System.out.println();
        bs.mob(); System.out.println();
        bs.net(); System.out.println();
        
        PaytmServices ps = context.getBean("ptmSrv", PaytmServices.class);
        ps.wallet();
        
        context.close();
    }
}
