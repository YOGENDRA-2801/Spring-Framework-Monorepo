package in.yoy.JpaProCRUD.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.yoy.JpaProCRUD.entity.Department;

public class App 
{
    public static void main( String[] args )
    {
//    	1. Create object for Factory - Manager - Transaction
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit") ;
        EntityManager entityManager = entityManagerFactory.createEntityManager() ;
        EntityTransaction entityTransaction = entityManager.getTransaction() ;
//      2. Begin Transaction - Perform CRUD - Commit / Rollback Transaction
        Department dept = new Department("Quality", 5, "Supereme") ;
        try {
			entityTransaction.begin(); 
			
//			----- INSERT OPERATION -----
			entityManager.persist(dept);
			System.out.println("INSERT OPERATION PERFORMED");
			
//			----- SELECT OPERATION -----
			Department selectedDepartment = entityManager.find(Department.class, dept.getId()) ;
			System.out.println("SELECT OPERATION PERFORMED");
			selectedDepartment.display();
			
//			----- MERGE OPERATION -----
			Department deptForUpdate = entityManager.find(Department.class, 1) ;
			deptForUpdate.setStrength(15);
			entityManager.merge(deptForUpdate) ; // Not needed as it will be automatically done when setter is executed
			System.out.println("UPDATE OPERATION PERFORMED");
			
//			----- DELETE OPERATION ----- 
			entityManager.remove(selectedDepartment);
			System.out.println("DELETE OPERATION PERFORMED");
			
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
