package in.yoy.SprHbrntXml.dao;

import in.yoy.SprHbrntXml.beans.Students;

public interface StudDaoIntrfc {
	public boolean insertStudent(Students students) ;
	public boolean deleteStudent(Students students) ;
	public boolean updateStudent(Students students) ;
	public Students retrieveStudent(int rollno) ;
}
