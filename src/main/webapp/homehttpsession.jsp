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

String userName = null;
String userPassword= null;

if( session.getAttribute("userName") != null && session.getAttribute("userPassword") !=null){
	 userName = session.getAttribute("userName").toString();
	 userPassword = session.getAttribute("userPassword").toString();
}



if(userName == null && userPassword == null){
	response.sendRedirect("loginhttpsession.jsp");
}


%>


<h1>Home Page</h1>
<h2>HttpSession Value : <%=userName%> </h2>

<br>
<a href="logouthttpsession">LogOut</a>


</body>
</html>