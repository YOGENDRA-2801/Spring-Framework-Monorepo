package in.yoy.SprDtaJpaQueMeth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yoy.SprDtaJpaQueMeth.entity.Employee;
import in.yoy.SprDtaJpaQueMeth.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmpSrvIntrf {

	@Autowired
	EmployeeRepository empRepo;
	
	public void getAllEmp() {
		List<Employee> empList = empRepo.findAll() ;
		for (Employee employee : empList) {
			employee.display();
		}
	}
	
	public void name() {
		
	}
	
}