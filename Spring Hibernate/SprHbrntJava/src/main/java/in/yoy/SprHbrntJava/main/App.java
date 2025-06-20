package in.yoy.SprHbrntJava.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprHbrntJava.beans.Students;
import in.yoy.SprHbrntJava.resources.SpringConfigFile;
import in.yoy.SprHbrntJava.service.StudSrvcImplmt;
import in.yoy.SprHbrntJava.service.StudSrvcIntrfc;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Students std = context.getBean(Students.class , "stud") ;
        StudSrvcIntrfc stdSrv = context.getBean(StudSrvcImplmt.class, "studDaoService") ;
        stdSrv.insertStudSrvc(std) ;
//        stdSrv.retrieveStudSrvc(1) ;
        context.close() ;
    }
}
