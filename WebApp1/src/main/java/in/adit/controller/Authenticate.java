package in.adit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.adit.model.Employee;
import in.adit.model.DAO.EmployeeDAOImpl;

@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Employee employee = new Employee();
		employee.setUsername(un);
		employee.setPassword(pass);
		
		EmployeeDAOImpl daoImpl = new EmployeeDAOImpl();
		
		if(daoImpl.authenticate(employee)) {
			request.setAttribute("user", employee.getUsername());
			rd = request.getRequestDispatcher("home.jsp");
		}
		else {
			request.setAttribute("error", "invalid username or password");
			rd = request.getRequestDispatcher("login.jsp");
		}	
		rd.forward(request, response);
	}
}
