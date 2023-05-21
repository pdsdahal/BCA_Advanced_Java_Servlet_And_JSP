package com.unit4.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletConfigDemo implements Servlet {

	private ServletConfig servletConfig;
	
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}
	
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		
		PrintWriter printWriter =  servletResponse.getWriter();
		
		Enumeration<String> params =  servletConfig.getInitParameterNames();
		while(params.hasMoreElements()) {
			
			String paramName =  params.nextElement();
			String value =  servletConfig.getInitParameter(paramName);
			
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
