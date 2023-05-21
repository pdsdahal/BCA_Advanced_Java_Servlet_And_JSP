package com.unit4.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContextDemo extends GenericServlet {

	private ServletContext servletContext;
	
	public void init(ServletConfig servletConfig) throws ServletException {
		servletContext = servletConfig.getServletContext();
	}
	
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		
		PrintWriter printWriter =  servletResponse.getWriter();
		
		Enumeration<String> params =  servletContext.getInitParameterNames();
		while(params.hasMoreElements()) {
			
			String paramName =  params.nextElement();
			String value =  servletContext.getInitParameter(paramName);
			
			printWriter.println("Name : "+paramName);
			printWriter.println("Value : "+value);
		}
		
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
