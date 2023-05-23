package com.unit4.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName =  request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		response.setContentType("text/html");
		
		if(userName.equals("")|| password.equals("") || userName==null || password==null) {
			PrintWriter pw = response.getWriter();
			pw.println("Please enter valid credentails!");
			RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}else {
			
			if(userName.equals("Admin") && password.equals("Admin")) {
				RequestDispatcher rd =  request.getRequestDispatcher("home");
				rd.forward(request, response);
				
			}else {
				PrintWriter pw = response.getWriter();
				pw.println("UnAuthorized!");
				RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
		
	}
}
