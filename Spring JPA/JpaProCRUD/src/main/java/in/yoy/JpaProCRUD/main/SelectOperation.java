package in.yoy.JpaProCRUD.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.yoy.JpaProCRUD.entity.Department;



public class SelectOperation {
	public static void main(String[] args) {
		
//    	1. Create object for Factory - Manager [FOR SELECT TRANSACTION SUPPORT IS NOT REQUIRED]
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//      2. Perform Operation
		
//		----- Select operation using Query Interface -----
//		String sqlCmd = "SELECT dept FROM Department dept" ; // NO SEMICOLON AT END LIKE SQL CMD
//		Query query = entityManager.createQuery(sqlCmd) ;
//		List<Department> dept_info = query.getResultList() ;
//		for (Department department : dept_info) {
//			department.display();
//		}
		
//		----- Select operation using TypedQuery Interface -----
//		String sqlCmd = "SELECT dept FROM Department dept" ; // NO SEMICOLON AT END LIKE SQL CMD
//		TypedQuery<Department> query = entityManager.createQuery(sqlCmd, Department.class) ;
//		List<Department> dept_info = query.getResultList() ;
//		for (Department department : dept_info) {
//			department.display();
//		}
		
//		----- Select operation for fetching particular row -----
//		String sqlCmd = "SELECT dept FROM Department dept WHERE dept.id = :deptID" ; // USE PROPERTY NAME NOT COLUMN NAME
//		TypedQuery<Department> query = entityManager.createQuery(sqlCmd, Department.class) ;
//		query.setParameter("deptID", 3) ; // KEY NAME SHOULD BE SAME
//		Department dept = query.getSingleResult() ;
//		dept.display();
		
//		----- Select operation for fetching particular columns -----
		String sqlCmd = "SELECT dept.name, dept.head FROM Department dept" ;
		TypedQuery<Object[]> query = entityManager.createQuery(sqlCmd, Object[].class) ;
//		SINCE WE ARE FETCHING INDIVIDUAL COLUMN'S WHERE EACH COLUMN CAN BE OF DIFFERENT DATA-TYPE HENCE USED OBJECT[] 
//		SINCE WE ARE NOT FETCHING AN COMPLETE ROW HENCE NO ENTITY IS FETCHED THEREFORE CAN'T USE ENTITY CLASS TYPE
//		SINCE WE ARE FETCHING MULTIPLE COLUMNS HENCE USED AN ARRAY TYPE
		List<Object[]> dept_info = query.getResultList() ;
		for (Object[] objects : dept_info) {
			System.out.print("DEPARTMENT ID : " + objects[0]);
			System.out.println(" , DEPARTMENT HEAD : " + objects[1]);
		}
		
//		----- Select operation for fetching single colum -----
//		String sqlCmd = "SELECT dept.name FROM Department dept" ;
//		TypedQuery<Object> query = entityManager.createQuery(sqlCmd, Object.class) ;
//		List<Object> dept_info = query.getResultList() ;
//		for (Object object : dept_info) {
//			String name = (String)object ;
//			System.out.println("DEPARTMENT NAME : " + name);
//		}
		
//      3. Close Resources
		entityManager.close();
		entityManagerFactory.close();
	}
}
