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
     <td><input type="text" name="username" minlength="6" maxlength="20"/></td></tr>
     <tr><td colspan="2"> <%if(request.getAttribute("invalidUsername")!=null&&(boolean)request.getAttribute("invalidUsername")){ %>
     <p style="color:red">username must have length 6 to 20 contains letters and numbers only</p><%} %> </td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" minlength="8" maxlength="32"/></td></tr>
    <tr colspan"2"> <td > <%if(request.getAttribute("invalidPassword")!=null&&(boolean)request.getAttribute("invalidPassword")){ %>
     <p style="color:red">password must have length 8 to 32 contains letters,numbers special characters </p><%} %> </td>
    </tr>
    <tr style="height:50px">
    <td><input type="submit" name="user_button" value="user signin" /></td>
    <td style="text-align:right"><input type="submit" name="user_button" value="admin signin" /></td>
    </tr>
    <tr>
    <td>New user?</td>
    <td><input type="submit" name="user_button" value="Register"/></td>
    </tr>
      <tr>
    <td> forgot password?</td>
    <td><input type="submit" name="user_button" value="click"/></td>
    </tr>
   </table>
   </form>
   <%if(null!=request.getAttribute("details")&&(int)request.getAttribute("details")==0){%>
	   <p style="color:red">please Enter valid details</p>
 <% }Text
   else if(null!=request.getAttribute("details")&&(int)request.getAttribute("details")==1){%>
	   <p style="color:red">please login first</p>
 <% } %>
  
 </div>
</body>
</html>