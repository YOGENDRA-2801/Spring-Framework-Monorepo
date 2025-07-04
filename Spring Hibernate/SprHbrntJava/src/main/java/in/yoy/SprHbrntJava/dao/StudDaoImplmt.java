package in.yoy.SprHbrntJava.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import in.yoy.SprHbrntJava.beans.Students;

public class StudDaoImplmt implements StudDaoIntrfc {
	
	private HibernateTemplate hbTemp ;

	public void setHbTemp(HibernateTemplate hbTemp) {
		this.hbTemp = hbTemp;
	}

	@Transactional
	@Override
	public boolean insertStudent(Students students) {
		try {
			hbTemp.persist(students) ;
			return true;
		} catch (Exception e) {
			System.out.println("\nINSERTION OPERATION FAILED DUE TO THE MENTIONED REASON\n");
			e.printStackTrace();
			return false;
		}		
	}

	@Transactional
	@Override
	public boolean deleteStudent(Students students) {
		try {
			hbTemp.delete(students) ;
			return true;
		} catch (Exception e) {
			System.out.println("\nDELETE OPERATION FAILED DUE TO THE MENTIONED REASON\n");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateStudent(Students students) {
		try {
			hbTemp.merge(students) ;
			return true;
		} catch (Exception e) {
			System.out.println("\nUPDATE OPERATION FAILED DUE TO THE MENTIONED REASON\n");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Students retrieveStudent(int rollno) {
		try {
			Students stud = hbTemp.get(Students.class, rollno) ;
			return stud;
		} catch (Exception e) {
			System.out.println("\nRETRIEVE OPERATION FAILED DUE TO THE MENTIONED REASON\n");
			e.printStackTrace();
			return null;
		}
	}

}
