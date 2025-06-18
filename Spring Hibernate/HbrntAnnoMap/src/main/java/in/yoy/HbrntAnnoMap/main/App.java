package in.yoy.HbrntAnnoMap.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.yoy.HbrntAnnoMap.beans.Students;

public class App {
	public static void main(String[] args) {
//      CREATE BEAN OBJECT & INITIALIZE IT'S PROPERTY
		Students stud = new Students("Yogendra", "BSCIT", new BigDecimal(429.65));

//      CRT CONFIG (TO_CONFIGURE_&_MANAGE_HBRNT_SETTINGS) , SF(TO_CREATE_SESSION) & SESSION OBJECT(TO_PERFORM_OPERATION)
		Configuration cfg = new Configuration(); // hibernate package wala
		cfg.configure("/in/yoy/HbrntAnnoMap/resources/hibernate.cfg.xml"); // load config detail
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

//      CRT TRANSACTION OBJ AS EVERY OPERATION IN HBRNT IS CONSIDERED AS TRANSATION
		Transaction transaction = session.beginTransaction();

		try {
//    		Koi kuch exception throw nahi kar raha we used try-catch bcoz if kuch unexpected issue aaya to rollback kr sake
			session.persist(stud); // hibernate will create insert SQL query automatically
			System.out.println("success");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
