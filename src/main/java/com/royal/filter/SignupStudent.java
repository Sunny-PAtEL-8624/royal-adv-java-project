package com.royal.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import com.royal.util.DbConnection;

@WebFilter("/AddStudentServlet")
public class SignupStudent implements javax.servlet.Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization code, if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		boolean isValid = true;

		// Retrieve form parameters
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("number");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String birthdate = request.getParameter("birthdate");
		String aadharCard = request.getParameter("aadharcard");
		String password = request.getParameter("password");
		String dbEmail = "";
		String  dbAdharCard = "";
		boolean foundEmail = false;
		boolean foundAdharCard = false;
		try {
			Connection conn = DbConnection.getConnection();
			
			 String sql = "SELECT * FROM student ";
	         PreparedStatement pstmt = conn.prepareStatement(sql);





	         // 5. Execute the query
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next()) {
	        	 dbEmail = rs.getString("email");
	        	 dbAdharCard = rs.getString("aadhar_card_number");
	        	 System.out.println(dbEmail + " "+ dbAdharCard);
	        	 if(email.equals(dbEmail))
	        	 {
	        		 
	        		 foundEmail = true;
	        	 }
	        	 if(aadharCard.equals(dbAdharCard))
	        	 {
	        		 
	        		 foundAdharCard= true;
	        	 }

	         }
	         
	       
	         
			}
			catch(Exception e)
			{
				
			}

		if (firstName == null || firstName.trim().length() == 0) {
			isValid = false;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		}

		if (lastName == null || lastName.trim().length() == 0) {
			isValid = false;
			request.setAttribute("lastNameError", "please Enter lastname");
		}

		if (email == null || email.matches("")) {
			isValid = false;
			request.setAttribute("emailError", "please Enter vaild email");
		}

		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			isValid = false;
			request.setAttribute("phoneNumberError", "please enter the number");
		}

		if (gender == null || (!gender.equals("male") && !gender.equals("female") && !gender.equals("other"))) {
			isValid = false;
			request.setAttribute("genderError", "please select the gender");
		}

		if (address == null || address.isEmpty()) {
			isValid = false;
			request.setAttribute("addressError", "please enter the address");
		}

		if (birthdate == null || birthdate.isEmpty()) {
			isValid = false;
			request.setAttribute("birthdateError", "please enter the DOB");
		}

		if (aadharCard == null || !aadharCard.matches("\\d{12}")) {
			isValid = false;
			request.setAttribute("aadharCardError", "please enter the addarcard number");
		}
		if(password == null || password.trim().isEmpty()) {
			isValid = false;
			request.setAttribute("passwordError", "please enter the password in 8 number");
		}

		if(foundEmail)
		{
			request.setAttribute("emailExistsError", "Email Is Already Exist");
			isValid = false;
		}
		if(foundAdharCard)
		{
			request.setAttribute("aadharExistsError", "Aadhar-Number Is Already Exist");
			isValid = false;
		}
		if (isValid) {
			// back
			chain.doFilter(request, response);
		} else {
			// forward
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		// Continue the filter chain if validation passes
	}

	@Override
	public void destroy() {
		// Cleanup code, if needed
	}


}