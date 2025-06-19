package in.yoy.SprHbrntXml.service;

import in.yoy.SprHbrntXml.beans.Students;
import in.yoy.SprHbrntXml.dao.StudDaoImplmt;

public class StudSrvcImplmt implements StudSrvcIntrfc {

	private StudDaoImplmt studDao;

	public void setStudDao(StudDaoImplmt studDao) {
		this.studDao = studDao;
	}

	public StudDaoImplmt getStudDao() {
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
