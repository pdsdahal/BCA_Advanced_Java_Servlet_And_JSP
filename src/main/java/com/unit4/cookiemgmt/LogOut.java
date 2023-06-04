package com.unit4.cookiemgmt;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOut extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie userCookie = null;
		String userCookieValue = null;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userlogin")) {
					userCookie = cookie;
					userCookieValue = cookie.getValue();
					break;
				}
			}
		}
	
		if(userCookie != null || userCookieValue != null) {
			userCookie.setMaxAge(0);
			response.addCookie(userCookie);
		}
		response.sendRedirect("logincookie.jsp");
	}

	public void destroy() {

	}
}
