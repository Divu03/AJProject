package in.adit.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.adit.model.Employee;

public class EmplyeeDAOImpl implements EmployeeDAO{
	
	Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	
	public EmplyeeDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "");
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean authenticate(Employee employee) {
		try {
			String query = "SELECT * FROM login_tbl WHERE username = ? AND password = ?;";
			
			pstm.setString(1, employee.getUsername());
			pstm.setString(2, employee.getPassword());
			
			rs = pstm.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee upgateEmployee(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
