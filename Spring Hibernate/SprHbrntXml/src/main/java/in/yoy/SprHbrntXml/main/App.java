package in.yoy.SprHbrntXml.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.yoy.SprHbrntXml.beans.Students;
import in.yoy.SprHbrntXml.service.StudSrvcImplmt;
import in.yoy.SprHbrntXml.service.StudSrvcIntrfc;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/in/yoy/SprHbrntXml/resources/ApplicationContext.xml");
        Students std = context.getBean(Students.class , "stud") ;
        StudSrvcIntrfc stdSrv = context.getBean(StudSrvcImplmt.class, "studDaoService") ;
        stdSrv.insertStudSrvc(std) ;
        context.close() ;
    }
}