package in.yoy.SprHbrntJava.service;

import in.yoy.SprHbrntJava.beans.Students;

public interface StudSrvcIntrfc {
	public void insertStudSrvc(Students students) ;
	public void deleteStudSrvc(Students students) ;
	public void updateStudSrvc(Students students) ;
	public void retrieveStudSrvc(int rollno) ;
}
