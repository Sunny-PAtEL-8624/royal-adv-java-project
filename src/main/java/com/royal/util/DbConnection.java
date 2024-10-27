package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection()
	{
		Connection conn = null;
		String dbUrl = "jdbc:mysql://localhost:3306/royal-adv-java";
		String name = "root";
		String password = "Sunny_patel_8624";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, name, password);
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
//	
//	public static void main(String[] args) {
//		System.out.println(getConnection());
//	}


}
