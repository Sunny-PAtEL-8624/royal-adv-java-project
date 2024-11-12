package com.royal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


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

		if (firstName == null || firstName.trim().length() == 0) {
			isValid = false;
			request.setAttribute("firstName", "Please Enter FirstName");
		}

		if (lastName == null || lastName.trim().length() == 0) {
			isValid = false;
			request.setAttribute("lastName", "please Enter lastname");
		}

		if (email == null || !email.matches("^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$")) {
			isValid = false;
			request.setAttribute("email", "please Enter vaild email");
		}

		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			isValid = false;
			request.setAttribute("phoneNumber", "please enter the number");
		}

		if (gender == null || (!gender.equals("male") && !gender.equals("female") && !gender.equals("other"))) {
			isValid = false;
			request.setAttribute("gender", "please select the gender");
		}

		if (address == null || address.isEmpty()) {
			isValid = false;
			request.setAttribute("address", "please enter the address");
		}

		if (birthdate == null || birthdate.isEmpty()) {
			isValid = false;
			request.setAttribute("birthdate", "please enter the DOB");
		}

		if (aadharCard == null || !aadharCard.matches("\\d{12}")) {
			isValid = false;
			request.setAttribute("aadharCard", "please enter the addarcard number");
		}
		if(password == null || password.trim().isEmpty()) {
			isValid = false;
			request.setAttribute("password", "please enter the password in 8 number");
		}

		if (isValid) {
			// back
			chain.doFilter(request, response);
		} else {
			// forward
			request.getRequestDispatcher("addstudent.jsp").forward(request, response);
		}

		// Continue the filter chain if validation passes
	}

	@Override
	public void destroy() {
		// Cleanup code, if needed
	}


}