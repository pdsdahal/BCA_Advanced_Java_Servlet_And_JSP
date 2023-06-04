package com.unit4.cookiemgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		PrintWriter pw =  response.getWriter();
		
		if(username.equals("") || username == null || password.equals("") || password==null) {
			pw.println("Please enter valid credentials!");
			RequestDispatcher rd = request.getRequestDispatcher("logincookie.jsp");
			rd.include(request, response);
		}else {
			if(username.equals("Admin") && password.equals("Admin")) {
				Cookie cookie = new Cookie("userlogin", username+password);
				cookie.setMaxAge(10000);
				response.addCookie(cookie);
				response.sendRedirect("homecookie.jsp");	
			}else {
				pw.println("Unauthorized!!!");
				RequestDispatcher rd = request.getRequestDispatcher("logincookie.jsp");
				rd.include(request, response);
			}
		}
		pw.close();
	}
	
	
	public void destroy() {
		
	}

}
