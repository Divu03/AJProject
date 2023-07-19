package in.adit.model.DAO;

import java.util.List;

import in.adit.model.Employee;

public interface EmployeeDAO {
	
	public boolean authenticate(Employee employee);
	public boolean createEmployee(Employee employee);
	public boolean deleteEmployee(String username);
	public Employee upgateEmployee(String username);
	public Employee getEmployee(String username);
	public List<Employee> getAllEmployee();
	
}
