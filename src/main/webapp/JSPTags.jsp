<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Tags</title>
</head>
<body>


<p>JSP Comments Tag</p>
<%-- This is JSP Comments --%>


<p>ScriptLet Tag</p>

<%
int num1 = 10;
int num2 = 20;
int result = num1 + num2;
out.println(num1 + " + "+ num2 + " = "+result);
%>


<p>Declaration Tag</p>
<%!

public int sub(int num1, int num2){
	return num1-num2;
}

%>

<% out.println("20 - 10 = "+sub(20,10)); %>


<p>Expression Tag</p>

<%=sub(100,20) %>

<p>Directive Tag</p>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>

</body>
</html>