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

@WebServlet("/Regitration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/user";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	Connection connection = null;
	PreparedStatement statement = null;

	public Registration() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connect established succesfully");
		} catch (SQLException e) {
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
		int mobile = Integer.parseInt(request.getParameter("number"));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		try {
			String query = "INSERT INTO user_info_tbl VALUES (?,?,?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, un);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, email);
			statement.setInt(5, mobile);
			statement.execute(query);
			System.out.println("Query 1 Executed...");
			String query2 = "INSERT INTO login_tbl VALUES (?,?);";
			statement = connection.prepareStatement(query2);
			statement.setString(1,un);
			statement.setString(2,pass);
			statement.execute(query2);
			System.out.println("Query 2 Executed...");
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			out.println(e);
			e.printStackTrace();
		}

	}

}
