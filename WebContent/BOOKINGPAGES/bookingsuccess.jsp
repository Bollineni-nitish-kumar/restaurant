<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Availablebean"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:5%;width:90%;">
<tr style="height:10%">
<td  colspan="2" style="width:5%;text-align:left;"><input style="width:60px;height:35px;"type="submit" name="submit" value="home"/></td>
<td colspan="3" style="width:25%;text-align:right;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 
</tr>
</table>
</form>
<table style="height:20%;width:90%;">
<tr style="height:10%">
<td colspan="5" style="width:25%;text-align:center;vertical-align:bottom"><h4>Booking successfull</h4></td>
</tr>
</table>
<table style="height:5%;width:70%;left:15%; border:1px solid black;right:10%">
 <tr bgcolor="LightGreen">
<th style="height:100px ;text-align:center"><b>Table Number</b></th>
<th><b>Number of seats</b></th>
<th><b>cost per hour</b></th>
<th><b>Time slot</b></th></tr>
</table>
 <% List<Availablebean> list=(List<Availablebean>)request.getAttribute("bookedtables");
  for(Availablebean availbean:list){%>
	   <table id="table1" style="height:100px;width:70%;left:15%; right:10%;border:1px solid black ;border-collapse:collapse;">
            <tr>
                <td style="border:1px solid black;width:24.5%;text-align:center"><%=availbean.getTableno()%></td>
                <td style="border:1px solid black;width:28%;text-align:center"><%=availbean.getSeats()%></td>
                <td style="border:1px solid black;width:22.5%;text-align:center"><%=availbean.getCost()%></td>
                <%if(availbean.getTime()==12){ %> <td style="border:1px solid black;width:16%;text-align:center"><%=availbean.getTime()%> PM</td><% } 
               else if(availbean.getTime()>12){ %><td style="border:1px solid black;width:16%;text-align:center"><%=availbean.getTime()% 12%> PM</td><% }
               else{%> <td style="border:1px solid black;width:16%;text-align:center"><%=availbean.getTime()%> AM</td><%} %>
            </tr>
            </table>
 <%}%>
</div>
</body>
</html>