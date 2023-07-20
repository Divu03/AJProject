package in.adit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.adit.model.Employee;
import in.adit.model.DAO.EmployeeDAO;
import in.adit.model.DAO.EmployeeDAOImpl;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/user";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public Connection connection;
	public PreparedStatement statement;
	public PreparedStatement statement2;

	public Registration() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connect established succesfully");
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		String firstName = request.getParameter("password");
		String lastName = request.getParameter("password");
		String email = request.getParameter("password");
		String m = request.getParameter("mobile");
		Long mobile = Long.parseLong(m);
		
		Employee emp = new Employee();
		emp.setUsername(un);
		emp.setPassword(pass);
		emp.setEmail(email);
		emp.setFirstname(firstName);
		emp.setLastname(lastName);
		emp.setnumber(mobile);
		
		EmployeeDAOImpl empl = new EmployeeDAOImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		if(empl.createEmployee(emp)) {
			response.sendRedirect("login.jsp");
		}		

	}

}
