<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
    <%@page import="beans.Addbean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All tables</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/AdminredirectServlet" method="post">
<table style="height:8%;width:100%;left:2%;">
<tr>
<td style="width:5%;text-align:right;"> <input style="width:60px;background-color:LightYellow;height:35px;" type="submit" name="submit" value="back"/> </td>
<td style="width:5%;text-align:left;"> <input style="width:60px;background-color:LightGreen;height:35px;" type="submit" name="submit" value="home"/> </td>
<td style="width:20%;text-align:right;"> <input style="width:60px;height:35px;background-color:OrangeRed;"type="submit" name="submit" value="logout"/> </td> 
<td style="width:5%"></td>
</tr>
</table>
</form>
<table style="height:10%;width:90%;">
<tr style="height:10%">
<td colspan="5" style="width:25%;text-align:center;"><h4>Displaying all table details</h4></td>
</tr>
</table>
<form action="<%=request.getContextPath()%>/ManageServlet" method="post">
 <table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th style="height:50px;width:25%;text-align:center"><b>Table number</b></th>
<th style="width:25%;text-align:center"><b>Number of seats</b></th>
<th style="width:50%;text-align:center"><b>cost per hour</b></th>
 </tr>
 <tr>
 <td colspan="7"> <table style="height:5%;width:100%;left:15%; right:10%">
 <%List<Addbean> std = 
            (List<Addbean>) request.getAttribute("tabledata");
        for(Addbean bean:std){   %>
        	
            <tr style="width:100%;background-color:Cornsilk">
                <td style="height:100px;width:25%;text-align:center"><%=bean.getTableno()%></td>
                <td style="width:25%;text-align:center"><%=bean.getNoseats()%></td>
                <td style="width:50%;text-align:center"><%=bean.getPrice()%></td> 
            </tr>
     <%}%>
     </table></td></tr></table>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:30px;width:100px;font-size:15px;background-color:LightSalmon;" type="submit" id="checkBtn"name="submit" value="manage"/>  
 </td></tr></table>
 </form>
  </div>
</body>
</html>