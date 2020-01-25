package andrew.thomas.dao;

import java.util.List;

import andrew.thomas.entity.Employee;

public interface EmployeeDAO {

	// get list of employees
	List<Employee> getEmployees();
	
	//Add Employee
	boolean addEmployee(Employee e);
	
	//get employee by id
	Employee getEmployee(int id );
	
	//update employee
	boolean updateEmployee(Employee e);
	
	//delete employee
	boolean deleteEmployee(Employee e);
}
