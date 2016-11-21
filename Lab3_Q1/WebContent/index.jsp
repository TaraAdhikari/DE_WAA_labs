<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab3_Q1</title>
</head>
<body>

<p> <b>Hello World </b></p>

<c:forEach var="i" begin="1" end="10">
  <b> <c:out value="${i}"/> <br> </b>
</c:forEach>

<%-- <% for(int i = 1; i<=10; i++){ %>
   
 <% out.println(i); %>
</br>

<%} %>
 --%>

</body>
</html>