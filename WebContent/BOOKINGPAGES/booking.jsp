<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.Availablebean"%>
       <%@page import="java.util.List"%>
    <%@page import="java.io.ByteArrayOutputStream" %>
     <%@page import="java.io.ObjectOutputStream" %>
     <%@page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<style>
.full{
height:90vh;
}
</style>
<meta charset="UTF-8">
<title>booking table</title>
</head>
<body style="background-color:beige">
<div align="center" class="full">
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:8%;width:100%;left:2%;">
<tr>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="back"/></td>
<td style="width:50%;text-align:center;"></td>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 

</tr></table>
</form>
<%if(session.getAttribute("recomdata")!=null){ %>
<%Availablebean availbean=(Availablebean)session.getAttribute("recomdata"); 
if(availbean.getTableno()==-1&&availbean.getTime()==-1){%>
<table style="height:20%;width:70%;left:15%;right:20%">
<tr>
<td colspan="5" style="text-align:center ;font-size:20px"><%if(request.getAttribute("freshUser")==null) %><h5>Your favourite table is not there..explore more from below</h5></td>
</tr>
</table>
<% }
else{ %>
<form action="<%=request.getContextPath() %>/BookingServlet" method="post">  
<table style="height:20%;width:70%;left:15%;right:20%">
<tr>
<td colspan="5" style="text-align:center ;font-size:20px"> <h5>your favourite table is available...book it</h5></td>
</tr>
<tr>
<td style="text-align:right"><b>table number:</b></td>
<td style="text-align:left;width:5%"><input style="width:50px" type="text" name="tableno" value="<%=availbean.getTableno()%>" readonly/></td>
<td style="text-align:right;width:7%"><b>time slot:</b></td>
<td style="text-align:left;width:5%"><input style="width:50px" type="text" name="timeslot" value="<%=availbean.getTime()%>"readonly /></td>
<td><input style="height:30px;width:150px;"type="submit" name="submit" value="book table"/></td>
</tr>
</table>
</form>
	
<%}  }%>
<table>
<tr>
<td style="height:100px"></td>
</tr>
</table>
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="get">
<table style="height:30%;width:70%; left:15%; right:20%">
<tr style="height:25%">
<td colspan="2" style="font-size:20px;text-align:center"><h5> please enter the preferred time slot to get tables.</h5>
</td></tr>
<tr>
<td style="width:50%;font-size:25px;text-align:right">select the time slot:</td>
<td style="text-align:left">
<select style="width:200px;height:40px;" name="time">
      <option style="font-size:20px" value="9">9 AM</option>
      <option style="font-size:20px" value="10">10 AM</option>
      <option style="font-size:20px" value="11">11 AM</option>
      <option style="font-size:20px" value="12">12 pM</option>
      <option style="font-size:20px" value="13">1 PM</option>
      <option style="font-size:20px" value="14">2 PM</option>
      <option style="font-size:20px" value="15">3 pM</option>
      <option style="font-size:20px" value="16">4 PM</option>
      <option style="font-size:20px" value="17">5 PM</option>
      <option style="font-size:20px" value="18">6 pM</option>
      <option style="font-size:20px" value="19">7 PM</option>
      <option style="font-size:20px" value="20">8 PM</option>
      <option style="font-size:20px" value="21">9 PM</option>
</select></td>
</tr>
 <tr style="height:3%">
<td colspan="2" style="font-size:15px;text-align:center">one slot is valid for one hour</td></tr>
 <tr style="height:25% ">
<td colspan="2" style="text-align:center"><input style="height:50px;width:100px;font-size:20px;background-color:Chartreuse" type="submit" name="submit" value="get tables"/></td>
 </tr>
 <tr style="height:60%"></tr>
</table>
</form>
<%if(request.getAttribute("alldetails")!=null){ %>
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
            (List<Availablebean>) request.getAttribute("alldetails");
        for(Availablebean bean:std){   
        	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	final ObjectOutputStream oos = new ObjectOutputStream(baos);
        	oos.writeObject(bean);
        	oos.flush();
        	final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));%>
             <table style="height:5%;width:70%;left:15%; right:10%">
            <tr style="background-color:White">
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
  <td style="font-size:30px;text-align:center"><input style="height:50px;width:150px;font-size:15px;background-color:SpringGreen;" type="submit" id="checkBtn"name="submit" value="book"/>  
 </td></tr></table>
</form>
<% } %>
</div>
</body>
</html>