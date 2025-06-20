package in.yoy.SprHbrntAnno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yoy.SprHbrntAnno.beans.Students;
import in.yoy.SprHbrntAnno.dao.StudDaoIntrfc;

@Service
public class StudSrvcImplmt implements StudSrvcIntrfc {

	@Autowired
	private StudDaoIntrfc studDao;

	public void setStudDao(StudDaoIntrfc studDao) {
		this.studDao = studDao;
	}

	public StudDaoIntrfc getStudDao() {
		return studDao;
	}

	@Override
	public void insertStudSrvc(Students students) {
		boolean status = studDao.insertStudent(students);
		if (status) {
			System.out.println("INSERTION OPERATION COMMITTED SUCCESSFULLY");
		}
	}

	@Override
	public void deleteStudSrvc(Students students) {
		boolean status = studDao.deleteStudent(students);
		if (status) {
			System.out.println("DELETE OPERATION COMMITTED SUCCESSFULLY");
		}
	}

	@Override
	public void updateStudSrvc(Students students) {
		boolean status = studDao.updateStudent(students);
		if (status) {
			System.out.println("UPDATE OPERATION COMMITTED SUCCESSFULLY");
		}
	}

	@Override
	public void retrieveStudSrvc(int rollno) {
		Students stud = studDao.retrieveStudent(rollno);
		if (stud != null) {
			stud.display();
		}
	}

}
