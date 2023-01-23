<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Availablebean"%>
    <%@page import="java.io.ByteArrayOutputStream" %>
     <%@page import="java.io.ObjectOutputStream" %>
     <%@page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>

</head>
<style>
div{
height:90vh;
}
</style>
<meta charset="UTF-8">
<title>available</title>
</head>
<body>


 <% if (session.getAttribute("userid")==null) {
    response.sendRedirect("LOGINPAGES/index.jsp");
}
else {} %> 
<div align="center">
<form action="<%=request.getContextPath() %>/BookingServlet" method="post">
<table style="height:5%;width:90%;">
<tr style="height:10%">
<td colspan="2" style="width:25%;text-align:left;"><input style="width:60px;height:35px;"type="submit" name="submit" value="back"/></td>
<td colspan="3" style="width:25%;text-align:right;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 
</tr>
</table>
</form>

<table style="height:10%;width:90%;">
<tr style="height:10%">
<td colspan="5" style="width:25%;text-align:center;"><h4> Available tables </h4></td>
</tr>
</table>


<table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th><b>select</b></th>
<th><b>Table Number</b></th>
<th><b>Number of seats</b></th>
<th><b>cost per hour</b></th>
<th><b>Time slot</b></th>

 </tr>
</table>
<form action="<%=request.getContextPath() %>/BookingServlet" method="post">
<%List<Availablebean> std = 
            (List<Availablebean>) request.getAttribute("tabledata");
        for(Availablebean bean:std){   
        	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	final ObjectOutputStream oos = new ObjectOutputStream(baos);
        	oos.writeObject(bean);
        	oos.flush();
        	final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));%>
             <table style="height:5%;width:70%;left:15%; right:10%">
            <tr style="background-color:Cornsilk">
                <td style="height:100px;text-align:center"><input style="height:20px;width:20px" type="checkbox" name="<%= "MY_JAVA_OBJECT" %>" value="<%= result%>"/></td>
                <td style="width:24.5%;text-align:center"><%=bean.getTableno()%></td>
                <td style="width:28%;text-align:center"><%=bean.getSeats()%></td>
                <td style="width:22.5%;text-align:center"><%=bean.getCost()%></td>
              <%if(bean.getTime()==12){ %> <td style="width:16%;text-align:center"><%=bean.getTime()%> PM</td><% } 
               else if(bean.getTime()>12){ %>    <td style="width:16%;text-align:center"><%=bean.getTime()% 12%> PM</td><% }
               else{%> <td style="width:16%;text-align:center"><%=bean.getTime()%> AM</td><%} %>
                   
            </tr>
            </table>
     <%}%>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:50px;width:150px;font-size:15px;background-color:PapayaWhip;" type="submit" id="checkBtn"name="submit" value="book"/>  
 </td></tr></table>
</form>
</div>
</body>
</html>