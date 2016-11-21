<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Star_Tara
  Date: 11/20/2016
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Guesss Number</title>
      <style>
          .error{ color: red; }
          .success{ color: darkgreen; }
      </style>
  </head>
  <body>
  <%
        HttpSession httpSession = request.getSession();
        String number = null;
        final int randonNumber;
        String errormsg = null;
        boolean sess = httpSession.isNew();
      boolean isSuccess = false;

    if(sess){
        randonNumber = (int) (Math.random() * 10);
        httpSession.setAttribute("rand", randonNumber);
        System.out.println("Random Number :" + randonNumber);
    }else{
        randonNumber = (int) httpSession.getAttribute("rand");
        number = request.getParameter("number");
        if(number != null && number.length() > 0){
         int numb = Integer.parseInt(number);
            if(numb > randonNumber){
                errormsg = "Number is Larger than the randomNumner";

            }else if(numb < randonNumber){
                errormsg = "Number is Smaller than the randomNumner";

            }else{
                errormsg = "Congrats";
                isSuccess = true;
            }
        }
    }
  %>



    <div>
       <% if(errormsg != null){%>
            <p class="<% if(isSuccess){ %>
                                success <%
                            }else{ %>
                                error <%
                            } %>">
                <%=errormsg%>
            </p>
        <% } %>
      <form method="post">
        <input type="text" name="number" maxlength="2">
        <input type="submit" value="Enter">
      </form>
    </div>

  </body>
</html>
