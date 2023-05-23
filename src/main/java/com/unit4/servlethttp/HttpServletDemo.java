package com.unit4.servlethttp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletDemo extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

		System.out.println("Init");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		service(httpServletRequest, httpServletResponse);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestType = request.getMethod();

		if (requestType.equals("GET")) {
			doGet(request, response);
		} else if (requestType.equals("POST")) {
			doPost(request, response);
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		pw.println("<h1> This is Get Requst</h1>");
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("txtUserName");
		String rollNo = request.getParameter("txtRollNo");
		String gender = request.getParameter("gender");
		
		PrintWriter pw =  response.getWriter();
		pw.println(" UserName : "+userName);
		pw.println(" RollNo : "+rollNo);
		pw.println(" Gender : "+gender);
		pw.close();
		
	}

	public void destroy() {

	}

}
