<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Viewbean"%>
    <%@page import="java.io.ByteArrayOutputStream" %>
    <%@page import="java.io.ObjectOutputStream" %>
    <%@page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view booking</title>
<style>
div{
height:90vh;
}
</style>
</head>
<body>
 <% if (session.getAttribute("userid")==null) {
    response.sendRedirect("LOGINPAGES/index.jsp");
}
else {} %> 
<div align="center">
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
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
<td colspan="5" style="width:25%;text-align:center;"><h4>Displaying booking details</h4></td>
</tr>
</table>
<table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th style="width:10%;text-align:center"><b>select to cancel</b></th>
<th style="width:10%;text-align:center"><b>Table Number</b></th>
<th style="width:10%;text-align:center"><b>Number of seats</b></th>
<th style="width:10%;text-align:center"><b>cost per hour</b></th>
<th style="width:10%;text-align:center"><b>Time slot</b></th>
<th style="width:15%;text-align:center"><b>First name</b></th>
<th style="width:15%;text-align:center"><b>Last name</b></th>
<th style="width:20%;text-align:center"><b>mobile number</b></th>
 </tr>
</table>
<form action="<%=request.getContextPath() %>/CancelServlet" method="post">
<%List<Viewbean> std = 
            (List<Viewbean>) request.getAttribute("userdata");
        for(Viewbean bean:std){   
        	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	final ObjectOutputStream oos = new ObjectOutputStream(baos);
        	oos.writeObject(bean);
        	oos.flush();
        	final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));%>
             <table style="height:5%;width:70%;left:15%; right:10%">
            <tr style="background-color:Cornsilk">
                <td style="width:10%; height:100px;text-align:center"><input style="height:25px;width:25px;" type="checkbox" name="<%= "MY_JAVA_OBJECT" %>" value="<%= result%>"/></td>
                <td style="width:10%;text-align:center"><%=bean.getTableno()%></td>
                <td style="width:10%;text-align:center"><%=bean.getNoseats()%></td>
                <td style="width:10%;text-align:center"><%=bean.getCost()%></td>
                 <%if(bean.getTime()==12){ %> <td style="width:10%;text-align:center"><%=bean.getTime()%> PM</td><% } 
               else if(bean.getTime()>12){ %>    <td style="width:10%;text-align:center"><%=bean.getTime()% 12%> PM</td><% }
               else{%> <td style="width:10%;text-align:center"><%=bean.getTime()%> AM</td><%} %>
                 <td style="width:15%;text-align:center"><%=bean.getFirstname()%></td>
                <td style="width:15%;text-align:center"><%=bean.getLastname()%></td>
                 <td style="width:20%;text-align:center"><%=bean.getPhone()%></td>
            </tr>
            </table>
     <%}%>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:30px;width:100px;font-size:15px;background-color:LightSalmon;" type="submit" id="checkBtn"name="submit" value="cancel"/>  
 </td></tr></table>
</form> </div>
</body>
</html>