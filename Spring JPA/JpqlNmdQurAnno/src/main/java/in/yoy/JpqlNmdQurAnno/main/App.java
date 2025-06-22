package in.yoy.JpqlNmdQurAnno.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import in.yoy.JpqlNmdQurAnno.entity.Department;

public class App 
{
    public static void main( String[] args )
    {
//    	1. Create object for Factory - Manager - Transaction
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//      2. Begin required operation [select operation]
		
//		PROGRAM - 1
//		TypedQuery<Department> query1 = entityManager.createNamedQuery("selectAll", Department.class) ;
//		List<Department> dept_info1 = query1.getResultList() ;
//		for (Department department : dept_info1) {
//			department.display();
//		}
//		
//		TypedQuery<Department> query2 = entityManager.createNamedQuery("selectWhere", Department.class) ;
//		query2.setParameter("deptID", 3) ; 
//		Department dept2 = query2.getSingleResult() ;
//		dept2.display();
		
//		PROGRAM - 2
		TypedQuery<Object[]> query3 = entityManager.createNamedQuery("columnSelection", Object[].class) ;
		List<Object[]> dept_info3 = query3.getResultList() ;
		for (Object[] objects : dept_info3) {
			System.out.print("DEPARTMENT ID : " + objects[0]);
			System.out.println(" , DEPARTMENT HEAD : " + objects[1]);
		}
		
//      3. Close Resources
		entityManager.close();
		entityManagerFactory.close();
    }
}
