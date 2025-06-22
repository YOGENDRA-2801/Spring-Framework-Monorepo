package in.yoy.JpqlCrudPro.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import in.yoy.JpqlCrudPro.entity.Department;

public class App {
	public static void main(String[] args) {
//    	1. Create object for Factory - Manager - Transaction
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("main-persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction(); // FOR INSERT , UPDATE & DELETE ONLY
//      2. Begin Transaction - Perform CRUD - Commit / Rollback Transaction
		Department dept = new Department("Quality", 7, "Supereme");
		try {
			entityTransaction.begin();

//			----- INSERT OPERATION (NO JPQL QUERY IS PRESENT FOR THIS OPERATION) -----
//			entityManager.persist(dept);
//			System.out.println("\nINSERT OPERATION PERFORMED\n");
//			System.out.println("ENTITY DATA AFTER INSERT OPERATION\n");
//			dept.display();

//			----- MERGE OPERATION -----
//			String sqlCmd1 = "UPDATE Department dept SET dept.strength = :headCount WHERE dept.name = :sectionName";
//			Query query1 = entityManager.createQuery(sqlCmd1);
//			query1.setParameter("headCount", 11);
//			query1.setParameter("sectionName", "Quality");
//			int count1 = query1.executeUpdate();
//			if (count1>0) {
//				System.out.println("\nUPDATE OPERATION PERFORMED\n");
//				System.out.println("ENTITY DATA AFTER UPDATE OPERATION\n");
//			}
//			dept.display();

//			----- DELETE OPERATION ----- 
			String sqlCmd2 = "DELETE Department dept WHERE dept.name = :sectionName";
			Query query2 = entityManager.createQuery(sqlCmd2);
			query2.setParameter("sectionName", "Quality");
			int count2 = query2.executeUpdate();
			if (count2>0) {
				System.out.println("\nDELETE OPERATION PERFORMED\n");
				System.out.println("ENTITY DATA AFTER DELETE OPERATION\n");
			}
			dept.display();

			entityTransaction.commit();
			System.out.println("\nTRANSACTION COMMITTED SUCESSFULLY\n");
		} 
		catch (Exception e) {
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
