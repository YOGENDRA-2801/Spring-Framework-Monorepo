package in.yoy.JpaProAnno.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.yoy.JpaProAnno.entities.Department;

public class App 
{
    public static void main( String[] args )
    {
//    	1. Create object for Factory - Manager - Transaction
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit") ;
        EntityManager entityManager = entityManagerFactory.createEntityManager() ;
        EntityTransaction entityTransaction = entityManager.getTransaction() ;
//      2. Begin Transaction - Perform CRUD - Commit / Rollback Transaction
        Department dept = new Department("DevOps", 9, "Satish") ;
        try {
			entityTransaction.begin(); 
			entityManager.persist(dept);
			entityTransaction.commit(); 
			System.out.println("OPERATION COMMITTED SUCESSFULLY");
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
