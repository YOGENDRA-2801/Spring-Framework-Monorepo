package in.yoy.SprJpaJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yoy.SprJpaJava.dao.DeptDaoInterface;
import in.yoy.SprJpaJava.entity.Department;

@Service
public class DeptServiceImplement implements DeptServiceInterface {

	@Autowired
	DeptDaoInterface deptDao ;
	
	public void setDeptDao(DeptDaoInterface deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public void insDept(Department dept) {
		boolean status = deptDao.addDept(dept) ;
		if (status) {
			System.out.println("\nINSERTION COMPLETED\n");
		}
	}

	@Override
	public void updtHod(Department dept, String new_hod) {
		boolean status = deptDao.chngHod(dept, new_hod) ;
		if (status) {
			System.out.println("\nCHANGES COMMITED\n");
		}
	}

	@Override
	public void rtrDept(int pk) {
		Department dept = deptDao.getDept(pk) ;
		if (dept != null) {
			dept.display();
		}
	}

	@Override
	public void rmvDept(Department dept) {
		boolean status = deptDao.delDept(dept) ;
		if (status) {
			System.out.println("DELETION COMPLETED");
		}
	}

}
