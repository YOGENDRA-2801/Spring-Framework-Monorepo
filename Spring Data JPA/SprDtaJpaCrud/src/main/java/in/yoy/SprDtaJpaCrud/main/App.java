package in.yoy.SprDtaJpaCrud.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprDtaJpaCrud.entity.Employee;
import in.yoy.SprDtaJpaCrud.resources.SpringConfigFile;
import in.yoy.SprDtaJpaCrud.service.EmployeeService;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
        Employee e1 = context.getBean("employee", Employee.class) ;
        EmployeeService empSrv = context.getBean("employeeService", EmployeeService.class) ;
        empSrv.addEmp(e1);
        empSrv.getEmp(1);
        empSrv.updateEmp("Dev", 1);
        empSrv.getAllEmp() ;
        empSrv.delEmp(e1);
        context.close();
    }
}