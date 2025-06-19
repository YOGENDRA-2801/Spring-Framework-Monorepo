package in.yoy.SprHbrntJava.dao;

import in.yoy.SprHbrntJava.beans.Students;

public interface StudDaoIntrfc {
	public boolean insertStudent(Students students) ;
	public boolean deleteStudent(Students students) ;
	public boolean updateStudent(Students students) ;
	public Students retrieveStudent(int rollno) ;
}
