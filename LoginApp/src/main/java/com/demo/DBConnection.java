package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connect() {
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std","root","Vicky@96");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return con;
	
	}
}
