package in.yoy.SprHbrntXml.service;

import in.yoy.SprHbrntXml.beans.Students;

public interface StudSrvcIntrfc {
	public void insertStudSrvc(Students students) ;
	public void deleteStudSrvc(Students students) ;
	public void updateStudSrvc(Students students) ;
	public void retrieveStudSrvc(int rollno) ;
}
