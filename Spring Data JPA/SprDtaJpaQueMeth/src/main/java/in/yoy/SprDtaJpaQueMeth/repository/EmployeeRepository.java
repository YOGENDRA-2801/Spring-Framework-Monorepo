package in.yoy.SprDtaJpaQueMeth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.yoy.SprDtaJpaQueMeth.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	public Employee findByDesignationString(String designation) ;
	public void deleteByDesignationString(String designation) ;
	
	
}