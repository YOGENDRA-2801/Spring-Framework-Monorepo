package in.yoy.SprDtaJpaCrud.service;

import in.yoy.SprDtaJpaCrud.entity.Employee;

public interface EmpSrvIntrf {
	public void addEmp(Employee emp) ;
	public void delEmp(Employee emp) ;
	public void updateEmp(String promotedTo, int id) ;
	public void getEmp(int id) ;
	public void getAllEmp() ;
}