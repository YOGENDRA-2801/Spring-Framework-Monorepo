package in.yoy.SprDtaJpaQueMeth.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprDtaJpaQueMeth.entity.Employee;
import in.yoy.SprDtaJpaQueMeth.resources.SpringConfigFile;
import in.yoy.SprDtaJpaQueMeth.service.EmployeeService;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
        Employee e1 = context.getBean("employee", Employee.class) ;
        EmployeeService empSrv = context.getBean("employeeService", EmployeeService.class) ;
        
//      Using method naming convention
        
        
//      Using custom jpql queries
        
        
//      Using custom native sql queries 
        
        
        context.close();
    }
}
