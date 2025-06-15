package in.yoy.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import in.yoy.beans.Employee;

@Configuration
public class SpringConfigFile {
	
	@Bean("majdoor")
	@Scope("prototype")
	public Employee emp() {
		Employee emp = new Employee() ;
		emp.setDesignation("Dev");
		emp.setEmpcode(6538682);
		emp.setSalary(25000);
		return emp ;
	}

}
