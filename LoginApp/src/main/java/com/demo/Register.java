package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter writer = response.getWriter();
		Connection con=DBConnection.connect();
		try {
			PreparedStatement st=con.prepareStatement("insert into login_details values(?,?)");
			st.setString(1, user);
			st.setString(2, pass);
			int result=st.executeUpdate();
			if(result>0) {
				response.sendRedirect("success.html");
			}else {
				writer.print("please check ur credentials!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
