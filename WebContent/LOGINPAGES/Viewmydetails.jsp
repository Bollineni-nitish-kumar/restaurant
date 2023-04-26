<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="beans.Userbean"%>
       <%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view details</title>
</head>
<body>
<div align="center" class="full">
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:8%;width:100%;left:2%;">
<tr>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="back"/></td>
<td style="width:50%;text-align:center;"></td>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 

</tr></table>
</form>
<form action="<%=request.getContextPath() %>/UserServlet" method="post">
<table style="height:30%;width:70%; left:15%; right:20%">
<tr style="height:25%">
<td colspan="2" style="font-size:20px;text-align:center"><h5> please reenter your username and password to get details.</h5>
</td></tr>
<tr>
<td style="width:50%;font-size:25px;text-align:right">Enter username:</td>
<td style="text-align:left"><input type="text" name="username"/></td>
</tr>
<tr>
<td style="width:50%;font-size:25px;text-align:right">Enter password:</td>
<td style="text-align:left"><input type="password" name="password"/></td>
</tr>
<tr style="height:25% ">
<td colspan="2" style="text-align:center"><input style="height:50px;width:100px;font-size:20px;background-color:Chartreuse" type="submit" name="submit" value="get details"/></td>
 </tr>
 <tr style="height:60%"></tr>
</table>
</form>

<%if(request.getAttribute("userdetails")!=null){ %>
<table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th><b>User id</b></th>
<th><b>First name</b></th>
<th><b>Last name</b></th>
<th><b>Mobile</b></th>
<th><b>Gmail</b></th>
<th><b>User name</b></th>
<th><b>Password</b></th>

 </tr>
</table>

<%List<Userbean> std = 
            (List<Userbean>) request.getAttribute("userdetails");
        for(Userbean bean:std){%>
             <table style="height:5%;width:70%;left:15%; right:10%">
            <tr style="background-color:White">
                 <td style="width:10%;text-align:center"><%=bean.getUserid()%></td>
                <td style="width:15%;text-align:center"><%=bean.getFirstname()%></td>
                <td style="width:15%;text-align:center"><%=bean.getLastname()%></td>
                <td style="width:15%;text-align:center"><%=bean.getMobilno()%></td>
                <td style="width:15%;text-align:center"><%=bean.getGmail()%></td>
                <td style="width:15%;text-align:center"><%=bean.getUsername()%></td>
                <td style="width:15%;text-align:center"><%=bean.getPassword()%></td>
            </tr>
            </table>
<% } }%>
 
</div>
</body>
</html>