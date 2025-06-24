package in.yoy.SprJpaJava.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprJpaJava.entity.Department;
import in.yoy.SprJpaJava.resources.SpringConfigFile;
import in.yoy.SprJpaJava.service.DeptServiceImplement;
import in.yoy.SprJpaJava.service.DeptServiceInterface;

public class App 
{
    public static void main( String[] args )
    {
    	
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class) ;
        
        Department department = context.getBean("dept", Department.class) ;
        DeptServiceInterface deptService = context.getBean("deptServiceImplement", DeptServiceImplement.class) ;
        
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
