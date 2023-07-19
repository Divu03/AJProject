package in.adit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String URL = "jdbc:mysql://localhost:3306/user";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	Connection connection = null;
	PreparedStatement statement = null;
	
    public Authenticate() {
        super();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connect established succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		RequestDispatcher rd;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("hello");

		try {
			String query = "SELECT * FROM login_tbl WHERE username = ? AND password = ?;";
			statement.setString(1, un);
			statement.setString(2, pass);
			
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				response.sendRedirect("home.jsp");
			}
			else {
				request.setAttribute("error", "invalid");
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
