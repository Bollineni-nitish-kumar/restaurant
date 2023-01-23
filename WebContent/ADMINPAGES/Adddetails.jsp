<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Addbean"%>
<!DOCTYPE html>
<html>
<head>
<style>
#add{
width:100px;
height:50px;
}
td{
font-size:20px;
}



</style>
<meta charset="UTF-8">
<title>Adding table</title>
</head>
<body style="background-color:HoneyDew">
<div align="center">
<table style="float:left;height:8%;width:5%;left:2%;">
<tr>
<td style="width:100%;text-align:left;"><button style="width:60px;background-color:LightGreen;height:35px;" onclick="history.back()">Back</button>  </td>
</tr>
</table>

<form action="<%=request.getContextPath() %>/AdminredirectServlet" method="post">
<table style="height:8%;width:90%;left:10%;">
<tr>
<td style="width:5%;text-align:left;"> <input style="width:60px;background-color:LightGreen;height:35px;" type="submit" name="submit" value="home"/> </td>
<td style="width:20%;text-align:right;"> <input style="width:60px;height:35px;background-color:OrangeRed;"type="submit" name="submit" value="logout"/> </td> 
<td style="width:3%"></td>
</tr>
</table>
</form>
<h1>Add details here</h1>
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
<form action="<%=request.getContextPath()%>/AddServlet" method="post">
<table style="height:5%;width:70%;left:15%; right:10%">
 <tr style="width:100%;background-color:Cornsilk">
    <td style="height:100px;width:25%;text-align:center"><input style="height:50px;width:100px"type="number" name="table_number" required/></td>
    <td style="width:25%;text-align:center"><input style="height:50px;width:100px"type="number" name="no_seats" required/></td>
    <td style="width:50%;text-align:center"> <input style="height:50px;width:100px"type="number" name="cost_per_hour" step="0.01" required></td> 
  </tr>
  </table>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:30px;width:100px;font-size:15px;background-color:LightSalmon;" type="submit" id="add"name="submit" value="Add"/>  
 </td></tr></table>
</form>
</div>

</body>
</html>