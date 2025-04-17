package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentUtils 
{
	public static  Connection buildConnection() throws SQLException
	{
		String connectionUrl="jdbc:mysql://localhost:3306/cdac";
		String userName="root";
		String password="password";
		Connection dbConnection=DriverManager.getConnection(connectionUrl, userName, password);
		return dbConnection;
		
	}
}
