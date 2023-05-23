package com.unit4.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter();
		String userName =  request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		pw.println("<h1>Successfully login</h1>");
		pw.println("UserName : "+userName);
		pw.println("Password : "+password);
		pw.close();
		
	}

}
