package com.unit4.servletlifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudentLC implements Servlet {

	
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Init method");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<p> This is from Servlet</p>");
		printWriter.close();
	}

	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}	
}
