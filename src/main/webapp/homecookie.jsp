<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<%

String userCookie = null;

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie :  cookies){
		if(cookie.getName().equals("userlogin")){
			userCookie = cookie.getValue();
			break;
		}
		
	}
}

if(userCookie == null){
	response.sendRedirect("logincookie.jsp");
}

%>


<h1>Home Page</h1>
<h2>Cookie Value : <%=userCookie%> </h2>

<br>
<a href="logoutcookie">LogOut</a>


</body>
</html>