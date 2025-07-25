package in.yoy.HbrntCRUD.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.yoy.HbrntCRUD.beans.Students;

public class InsertOperation 
{
	public static void main( String[] args )
    {
//    	1. Create configuration object to provide configuration 
        Configuration cfg = new Configuration() ;
        cfg.configure("/in/yoy/HbrntCRUD/resources/hibernate.cfg.xml") ;
//      2. Create Session-Factory Object
        SessionFactory sessionFactory = cfg.buildSessionFactory() ;
//      3. Create Session Object
        Session session = sessionFactory.openSession() ;
//      4. Create Transaction Object to perform Update / Insert / Delete Operation 
        Transaction transaction = session.beginTransaction() ;
//      5. Perform CRUD Operation 
        Students stud1 = new Students("Satish", "BCS", new BigDecimal(543.21)) ;
        Students stud2 = new Students("Anand", "BSC", new BigDecimal(444.44)) ;
        try {
			session.save(stud1) ;
			session.persist(stud2); 
			transaction.commit() ;
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
