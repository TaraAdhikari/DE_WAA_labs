<%@ page session="true" %>
<%@ page import="org.domain.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Lab 2</title>
  </head>
  <body>

  <form action="allnameservlet" method="get">
      <input type="submit" value="Show All Names">
  </form>

  <form action="addnamesservlet" method="post">
    <p>
      Key         = <input type="number" name="key"> &nbsp;
      First Name  = <input type="text" name="fname"> &nbsp;
      Last Name   = <input type="text" name="lname">&nbsp;
                    <input type="submit" value="Add Person">
    </p>
  </form>

  <%
      if (session.getAttribute("error") !=null) {
          String error = (String) session.getAttribute("error"); %>
  <p style="color: darkslategrey">Error :: <%=error%></p>
  <% } %>


  <form method="post" action="removenameservlet">
      <p>
          Key = <input type="number" name="personkey">
                <input type="submit" value="Remove Person">
      </p>
  </form>

  <%
      if (session.getAttribute("errorremmsg") !=null) {
          String errorremmsg = (String) session.getAttribute("errorremmsg"); %>
  <p style="color: darkslategrey">Error :: <%=errorremmsg%></p>
  <% } %>


  </body>
</html>
