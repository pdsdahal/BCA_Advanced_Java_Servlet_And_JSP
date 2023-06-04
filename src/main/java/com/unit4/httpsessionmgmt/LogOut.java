package com.unit4.httpsessionmgmt;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession(false);
		String userName = null;
		String userPassword = null;
		
		if( httpSession.getAttribute("userName") != null && httpSession.getAttribute("userPassword") !=null){
			 userName = httpSession.getAttribute("userName").toString();
			 userPassword = httpSession.getAttribute("userPassword").toString();
		}

		if(userName != null && userPassword != null){
			
			httpSession.setAttribute("userName", null);
			httpSession.setAttribute("userPassword", null);
			httpSession.invalidate();
		}
		
		response.sendRedirect("loginhttpsession.jsp");
	}

	public void destroy() {

	}
}
