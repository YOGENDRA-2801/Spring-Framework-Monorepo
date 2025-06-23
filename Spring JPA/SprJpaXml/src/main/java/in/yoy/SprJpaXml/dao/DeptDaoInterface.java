package in.yoy.SprJpaXml.dao;

import in.yoy.SprJpaXml.entity.Department;

public interface DeptDaoInterface {
	public boolean addDept(Department dept) ;
	public boolean chngHod(Department dept , String new_hod) ;
	public Department getDept(int pk) ;
	public boolean delDept(Department dept) ;
}
