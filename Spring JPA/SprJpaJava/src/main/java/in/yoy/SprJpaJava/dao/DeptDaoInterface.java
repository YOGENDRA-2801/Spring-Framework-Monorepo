package in.yoy.SprJpaJava.dao;

import in.yoy.SprJpaJava.entity.Department;

public interface DeptDaoInterface {
	public boolean addDept(Department dept) ;
	public boolean chngHod(Department dept , String new_hod) ;
	public Department getDept(int pk) ;
	public boolean delDept(Department dept) ;
}
