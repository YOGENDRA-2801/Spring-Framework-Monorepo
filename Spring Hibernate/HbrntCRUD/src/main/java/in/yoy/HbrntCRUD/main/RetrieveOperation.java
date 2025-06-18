package in.yoy.HbrntCRUD.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.yoy.HbrntCRUD.beans.Students;

public class RetrieveOperation {
	public static void main(String[] args) {
//    	1. Create configuration object to provide configuration 
		Configuration cfg = new Configuration();
		cfg.configure("/in/yoy/HbrntCRUD/resources/hibernate.cfg.xml");
//      2. Create Session-Factory Object
		SessionFactory sessionFactory = cfg.buildSessionFactory();
//      3. Create Session Object
		Session session = sessionFactory.openSession();
//      4. Perform CRUD Operation
		Students stud1 = session.get(Students.class, 4) ;
		stud1.display() ;
		Students stud2 = session.load(Students.class, 5) ;
		stud2.display() ;
//      5. Close the open resources
		session.close();
		sessionFactory.close();
	}
}
