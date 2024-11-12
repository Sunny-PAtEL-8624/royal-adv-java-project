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
@WebFilter("/LoginStudentServlet")
public class LoginStudentFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean foundEmail = false;
		String dbEmail = null;
		String dbPassword = null;
		try {
		Connection conn = DbConnection.getConnection();
		
		 String sql = "SELECT * FROM student  WHERE email = ?";
         PreparedStatement pstmt = conn.prepareStatement(sql);



         pstmt.setString(1, email);

         // 5. Execute the query
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
        	 dbEmail = rs.getString("email");
        	 dbPassword = rs.getString("password");
        	 if(email.equals(dbEmail))
        	 {
        		 
        		 foundEmail = true;
        	 }
         }
		}
		catch(Exception e)
		{
			
		}
		if(!foundEmail)
		{
			request.setAttribute("emailError", "EmailNotFound");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			if(password.equals(dbPassword))
			{
				chain.doFilter(request, response);
			}
			else
			{
				request.setAttribute("passwordError", "InValidPassword");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
