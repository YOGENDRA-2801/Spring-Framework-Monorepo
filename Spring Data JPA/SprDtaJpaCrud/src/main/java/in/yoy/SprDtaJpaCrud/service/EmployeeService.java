package in.yoy.SprDtaJpaCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yoy.SprDtaJpaCrud.entity.Employee;
import in.yoy.SprDtaJpaCrud.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmpSrvIntrf {

	@Autowired
	EmployeeRepository empRepo;

	public void addEmp(Employee emp) {
		try {
			empRepo.save(emp) ;
			System.out.println("EMPLOYEE ADDED");
		} catch (Exception e) {
			System.out.println("\nEMPLOYEE CANNOT BE ADDED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}		
	}

	public void delEmp(Employee emp) {
		try {
			empRepo.delete(emp) ;
			System.out.println("EMPLOYEE DELETED");
		} catch (Exception e) {
			System.out.println("\nEMPLOYEE CANNOT BE DELETED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}

	public void updateEmp(String promotedTo, int id) {
		try {
			Employee emp = empRepo.findById(id).get() ;
			emp.setDesignation(promotedTo);
			empRepo.save(emp) ;
			System.out.println("EMPLOYEE PROMOTED");
		} catch (Exception e) {
			System.out.println("\nEMPLOYEE CANNOT BE DELETED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}

	public void getEmp(int id) {
		try {
			Employee emp = empRepo.findById(id).get() ;
			emp.display() ;
		} catch (Exception e) {
			System.out.println("\nEMPLOYEE CANNOT BE RETRIVED DUE TO FOLLOWING REASON");
			e.printStackTrace();
		}
	}
	
	public void getAllEmp() {
		List<Employee> empList = empRepo.findAll() ;
		for (Employee employee : empList) {
			employee.display();
		}
	}
	
}