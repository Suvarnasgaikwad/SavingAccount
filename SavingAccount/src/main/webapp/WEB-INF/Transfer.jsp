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
<center><h1>Hi :${name}
<br>You are:${msg}<br>
</h1></center>

   <h1><a href="Cradit.jsp"> Cradit Amount </a></h1>
   <h1><a href="Debit.jsp"> Debit Amount</a></h1>
   <h1><a href="Transaction.jsp"> List of Transaction</a></h1>
   <form action="./logout.sp">
   <input type="submit" value="LogOut">
   </form>
   

</body>
</html>