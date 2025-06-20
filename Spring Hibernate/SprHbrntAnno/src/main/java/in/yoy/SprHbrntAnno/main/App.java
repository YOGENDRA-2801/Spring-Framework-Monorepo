package in.yoy.SprHbrntAnno.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.yoy.SprHbrntAnno.beans.Students;
import in.yoy.SprHbrntAnno.resources.SpringConfigFile;
import in.yoy.SprHbrntAnno.service.StudSrvcImplmt;
import in.yoy.SprHbrntAnno.service.StudSrvcIntrfc;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Students std = context.getBean("stud", Students.class) ;
        StudSrvcIntrfc stdSrv = context.getBean("studSrvcImplmt", StudSrvcImplmt.class) ;// bean name if not explicitly defined will be same as class / method name in camel case 
        stdSrv.insertStudSrvc(std) ;
//        stdSrv.retrieveStudSrvc(1) ;
        context.close() ;
    }
}