package com.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		Connection con=DBConnection.connect();
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select password from login_details where username='"+user+"'");
			String passFromJDBC=null;
			while(rs.next()) {
			 passFromJDBC=rs.getString(1);
			}
			if(pass.equals(passFromJDBC)) {
				 response.sendRedirect("logged.html");
				 
			}else {
				response.sendRedirect("failed.html");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	

}
