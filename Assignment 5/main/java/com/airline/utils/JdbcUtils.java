package com.airline.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
// add file connector jar file in lib  
	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Air_Ticket_Reservation_System", "root",
				"password");
		System.out.println("Connection establish successfully");
		return conn;
	}
}
