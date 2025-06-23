package in.yoy.SprJpaXml.service;

import in.yoy.SprJpaXml.entity.Department;

public interface DeptServiceInterface {
	public void insDept(Department dept) ;
	public void updtHod(Department dept , String new_hod) ;
	public void rtrDept(int pk) ;
	public void rmvDept(Department dept) ;
}
