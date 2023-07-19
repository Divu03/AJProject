package in.adit;

import java.util.List;

public interface EmployeeDAO {
	
	public boolean authenticate(Employee employee);
	public boolean createEmployee(Employee employee);
	public boolean deleteEmployee(String username);
	public Employee upgateEmployee(String username);
	public Employee getEmployee(String username);
	public List<Employee> getAllEmployee();
	
}
