package in.adit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
			statement = connection.createStatement();
			System.out.println("Connect established succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
		String pass = request.getParameter("password");

		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.print("Registration Succesfull");
		String query = "INSERT INTO user_tb VALUES ('" + un + "','" + pass + "');";
		try {
			statement.execute(query);
			out.println("Query Executed...");
		} catch (SQLException e) {
			out.println(e);
			e.printStackTrace();
		}

	}

}
