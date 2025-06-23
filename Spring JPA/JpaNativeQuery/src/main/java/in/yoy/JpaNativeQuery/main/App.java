package in.yoy.JpaNativeQuery.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.yoy.JpaNativeQuery.entity.Department;

public class App 
{
    public static void main( String[] args )
    {
//    	1. Create object for Factory - Manager - Transaction
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit") ;
        EntityManager entityManager = entityManagerFactory.createEntityManager() ;
        EntityTransaction entityTransaction = entityManager.getTransaction() ;
        
//      2. Begin Transaction - Perform CRUD - Commit / Rollback Transaction
        try {
			entityTransaction.begin(); 
//			USAGE OF SEMICOLON INSIDE NATIVE QUERY IS OPTIONAL (WILL NO GIVE ERROR IF USED & WILL ALSO RUN IF NOT USED)
//			----- INSERT OPERATION -----
			String insertCmd = "INSERT INTO department(dept_name, dept_strength, dept_head) VALUES (:naam, :count, :mukhiya) ;" ;
			Query query1 = entityManager.createNativeQuery(insertCmd, Department.class) ;
			query1.setParameter("naam", "Quality") ;
			query1.setParameter("count", 8) ;
			query1.setParameter("mukhiya", "Supereme") ;
			int count1 = query1.executeUpdate() ; // In JPQL no method is available for insertion operation
			if (count1>0) {
				System.out.println("INSERT OPERATION PERFORMED \n");
			}
			
//			----- UPDATE OPERATION -----
			String updateCmd = "UPDATE Department SET dept_head = :nayaMukhiya WHERE dept_name=:naam ;" ;
			Query query3 = entityManager.createNativeQuery(updateCmd, Department.class) ;
			query3.setParameter("nayaMukhiya", "Yogendra Yadav") ;
			query3.setParameter("naam", "Quality") ;
			int count3 = query3.executeUpdate() ;
			if (count3>0) {
				System.out.println("UPDATE OPERATION PERFORMED \n");
			}
			
//			----- SELECT OPERATION -----
			String selectCmd = "SELECT * FROM department ;" ; 
			Query query2 = entityManager.createNativeQuery(selectCmd, Department.class) ;
			List<Department> allDept = query2.getResultList() ;
			for (Department department : allDept) {
				department.display();
			}
			System.out.println("SELECT OPERATION PERFORMED\n");
			
//			----- DELETE OPERATION ----- 
			String deleteCmd = "DROP FROM Department WHERE dept_name = :naam ;" ;
			Query query4 = entityManager.createNativeQuery(deleteCmd, Department.class) ;
			query4.setParameter("naam", "Quality") ;
			int count4 = query3.executeUpdate() ;
			if (count4>0) {
				System.out.println("DELETE OPERATION PERFORMED \n");
			}
			
			entityTransaction.commit();
			System.out.println("TRANSACTION COMMITTED SUCESSFULLY");
		} catch (Exception e) {
			entityTransaction.rollback();
			System.out.println("TRANSACTION FAILED DUE TO FOLLOWING MENTIONED REASON");
			e.printStackTrace();
		}
        
//      3. Close Resources
        finally {
			entityManager.close();
			entityManagerFactory.close();
		}
    }
}