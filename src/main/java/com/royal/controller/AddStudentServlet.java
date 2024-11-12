package com.royal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.royal.util.DbConnection;
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String first_name = request.getParameter("firstName");
	        String last_name = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String phone_number = request.getParameter("number");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String birthdate = request.getParameter("birthdate");
	        String aadhar_card_number = request.getParameter("aadharcard");
	        String password = request.getParameter("password");
	        
	        try {
				
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	Connection conn = DbConnection.getConnection();
	        	
	        	  PreparedStatement pstmt =conn.prepareStatement( "INSERT INTO student (first_name, last_name, email, phone_number, gender, address, birthdate, aadhar_card_number,password) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
	        	  pstmt.setString(1, first_name);
	              pstmt.setString(2, last_name);
	              pstmt.setString(3, email);
	              pstmt.setString(4, phone_number);
	              pstmt.setString(5, gender);
	              pstmt.setString(6, address);
	              pstmt.setDate(7, java.sql.Date.valueOf(birthdate));
	              pstmt.setString(8, aadhar_card_number);
	              pstmt.setString(9, password);
	              
	              pstmt.executeUpdate();
	        } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	        
	}

}