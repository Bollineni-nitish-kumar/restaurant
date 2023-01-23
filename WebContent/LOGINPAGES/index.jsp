<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant booking</title>
</head>
<body style="background-color:Ivory">
<div align="center">
  <h1>Welcome to the restaurant</h1>
  <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
  
 
   <table >
    <tr style="height:50px">
     <td>UserName</td>
     <td><input type="text" name="username"/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password"/></td>
    </tr>
    <tr style="height:50px">
    <td><input type="submit" name="user_button" value="user signin" /></td>
    <td style="text-align:right"><input type="submit" name="user_button" value="admin signin" /></td>
    </tr>
    <tr>
    <td>New user?</td>
    <td><input type="submit" name="user_button" value="Register"/></td>
    </tr>
   </table>
  
   </form>
   <%if(null!=request.getAttribute("details")){%>
	   <p style="color:red">please Enter valid details</p>
 <% }
   %>
  
 </div>
</body>
</html>