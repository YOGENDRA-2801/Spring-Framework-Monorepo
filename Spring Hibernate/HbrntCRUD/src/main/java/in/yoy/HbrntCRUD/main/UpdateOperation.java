package in.yoy.HbrntCRUD.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.yoy.HbrntCRUD.beans.Students;

public class UpdateOperation {
	public static void main(String[] args) {
//    	1. Create configuration object to provide configuration 
		Configuration cfg = new Configuration();
		cfg.configure("/in/yoy/HbrntCRUD/resources/hibernate.cfg.xml");
//      2. Create Session-Factory Object
		SessionFactory sessionFactory = cfg.buildSessionFactory();
//      3. Create Session Object
		Session session = sessionFactory.openSession();
//      4. Create Transaction Object to perform Update / Insert / Delete Operation 
		Transaction transaction = session.beginTransaction();
		try {
//          5. Perform CRUD Operation 
			
			Students stud1 = session.load(Students.class, 4) ;
			stud1.setCourse("BSC-CS") ;
			session.update(stud1);
			
			Students stud2 = session.get(Students.class, 5) ;
			stud2.setCourse("BSC-CH") ;
			session.saveOrUpdate(stud2);
			
			Students stud3 = session.get(Students.class, 6) ;
			stud3.setCourse("HSC");
			session.merge(stud3) ;
			
			Students stud4 = new Students("Vivek", "BSC-IT", new BigDecimal(123.45)) ;
			session.merge(stud4) ;
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
//      6. Close the open resources
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}
