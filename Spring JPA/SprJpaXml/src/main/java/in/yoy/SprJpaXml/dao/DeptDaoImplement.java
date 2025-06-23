package in.yoy.SprJpaXml.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import in.yoy.SprJpaXml.entity.Department;

public class DeptDaoImplement implements DeptDaoInterface {
	
	@PersistenceContext // to injects entity manager
	EntityManager entityManager ;

	@Transactional
	@Override
	public boolean addDept(Department dept) {
		try {
			entityManager.persist(dept);
			return true ;
		} catch (Exception e) {
			System.out.println("\nINSERTION FAILED DUE TO FOLLOWING MENTIONED REASON \n");
			e.printStackTrace() ;
			return false ;
		}
	}

	@Transactional
	@Override
	public boolean chngHod(Department dept, String new_hod) {
		try {
			dept.setHead(new_hod) ;
			entityManager.merge(dept) ;
			return true ;
		} catch (Exception e) {
			System.out.println("\nUPDATION FAILED DUE TO FOLLOWING MENTIONED REASON \n");
			e.printStackTrace() ;
			return false ;
		}
	}
	
	@Override
	public Department getDept(int pk) {
		try {
			Department dept = entityManager.find(Department.class, pk) ;
			return dept ;
		} catch (Exception e) {
			System.out.println("\nSELECTION FAILED DUE TO FOLLOWING MENTIONED REASON \n");
			e.printStackTrace() ;
			return null ;
		}
	}

	@Transactional
	@Override
	public boolean delDept(Department dept) {
		try {
			entityManager.remove(dept);
			return true ;
		} catch (Exception e) {
			System.out.println("\nDELETION FAILED DUE TO FOLLOWING MENTIONED REASON \n");
			e.printStackTrace() ;
			return false ;
		}
	}
}
