package in.yoy.SprJpaXml.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.SprJpaXml.entity.Department;
import in.yoy.SprJpaXml.service.DeptServiceImplement;
import in.yoy.SprJpaXml.service.DeptServiceInterface;

public class App 
{
    public static void main( String[] args )
    {
    	
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/SprJpaXml/resources/ApplicationContext.xml") ;
        
        Department department = context.getBean("dept", Department.class) ;
        DeptServiceInterface deptService = context.getBean("service", DeptServiceImplement.class) ;
        
//      INSERT NEW DEPARTMENT INTO DB
        deptService.insDept(department); 
        
//      DISPLAY DEPARTMENT FROM DB
        int id = department.getId() ;
        deptService.rtrDept(id);
        
//      CHANGE HOD
        deptService.updtHod(department, "Yogendra Yadav");
        
//      DISPLAY UPDATED DEPARTMENT
        deptService.rtrDept(id);
        
//      DELETE DEPARTMENT
        deptService.rmvDept(department);
        
        context.close();        
    }
}