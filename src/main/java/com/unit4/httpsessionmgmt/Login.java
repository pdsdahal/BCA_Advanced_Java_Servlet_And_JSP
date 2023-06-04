package com.unit4.httpsessionmgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			RequestDispatcher rd = request.getRequestDispatcher("loginhttpsession.jsp");
			rd.include(request, response);
		}else {
			if(username.equals("Admin") && password.equals("Admin")) {
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("userName", username);
				httpSession.setAttribute("userPassword",password);
				response.sendRedirect("homehttpsession.jsp");	
			}else {
				pw.println("Unauthorized!!!");
				RequestDispatcher rd = request.getRequestDispatcher("loginhttpsession.jsp");
				rd.include(request, response);
			}
		}
		pw.close();
	}
	
	
	public void destroy() {
		
	}

}
