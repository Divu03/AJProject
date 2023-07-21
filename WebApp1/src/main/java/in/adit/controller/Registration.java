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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
