package in.adit.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.tribes.membership.cloud.CloudMembershipProvider;

import in.adit.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	Connection connection;
	PreparedStatement pstm;
	PreparedStatement statement;
	PreparedStatement statement2;
	ResultSet rs;
	String URL = "jdbc:mysql://localhost:3306/user";
	String id = "root";
	String password = "";
	
	public EmployeeDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,id,password);
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
			pstm = connection.prepareStatement(query);
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
		try {
			String query2 = "INSERT INTO login_tbl VALUES (?,?)";
			statement2 = connection.prepareStatement(query2);
			statement2.setString(1,employee.getUsername());
			statement2.setString(2,employee.getPassword());
			statement2.execute();
			System.out.println("Query 2 Executed...");
			
			String query = "INSERT INTO user_info_tbl VALUES (?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, employee.getUsername());
			statement.setString(2, employee.getFirstname());
			statement.setString(3, employee.getLastname());
			statement.setString(4, employee.getEmail());
			statement.setLong(5, employee.getNumber());
			statement.execute();
			System.out.println("Query 1 Executed...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
