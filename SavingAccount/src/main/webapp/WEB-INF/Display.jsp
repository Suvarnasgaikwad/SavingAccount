<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center> Hi
<%String name=request.getParameter("name"); %><br>
<%=name %> you are Successful registration 

<% response.sendRedirect("Reg.jsp"); %>
</body>
</html>