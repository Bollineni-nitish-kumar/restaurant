<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Adminviewbean"%>
    <%@page import="java.io.ByteArrayOutputStream" %>
    <%@page import="java.io.ObjectOutputStream" %>
    <%@page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view all bookings</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('#select_all').on('click',function(){
        if(this.checked){
            $('.checkbox').each(function(){
                this.checked = true;
            });
        }else{
             $('.checkbox').each(function(){
                this.checked = false;
            });
        }
    });
    
    $('.checkbox').on('click',function(){
        if($('.checkbox:checked').length == $('.checkbox').length){
            $('#select_all').prop('checked',true);
        }else{
            $('#select_all').prop('checked',false);
        }
    });
});
</script>
</head>
<body>



 <% if (session.getAttribute("Username")==null) {
    response.sendRedirect("LOGINPAGES/index.jsp");
}
else {} %> 
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
<td colspan="5" style="width:25%;text-align:center;"><h4>Displaying all booking details</h4></td>
</tr>
</table>

   <form action="<%=request.getContextPath()%>/ManageServlet" method="post">
 <table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th style="height:50px;width:10%;text-align:center"><input style="height:20px;width:20px"type="checkbox" id="select_all"/></th>
<th style="width:10%;text-align:center"><b>Slot id</b></th>
<th style="width:10%;text-align:center"><b>Table number</b></th>
<th style="width:10%;text-align:center"><b>Number of seats</b></th>
<th style="width:20%;text-align:center"><b>cost per hour</b></th>
<th style="width:20%;text-align:center"><b>Time slot</b></th>
<th style="width:20%;text-align:center"><b>User name</b></th>
 </tr>
 <tr>
 <td colspan="7"> <table style="height:5%;width:100%;left:15%; right:10%">
 <%List<Adminviewbean> std = 
            (List<Adminviewbean>) request.getAttribute("userdata");
        for(Adminviewbean bean:std){   
        	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	final ObjectOutputStream oos = new ObjectOutputStream(baos);
        	oos.writeObject(bean);
        	oos.flush();
        	final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));%>
            <tr style="width:100%;background-color:Cornsilk">
                <td style="width:10%; height:100px;text-align:center"><input style="height:25px;width:25px;" type="checkbox" class="checkbox" name="<%= "MY_JAVA_OBJECT" %>" value="<%= result%>"/></td>
                <td style="width:10%;text-align:center"><%=bean.getSlotid()%></td>
                <td style="width:10%;text-align:center"><%=bean.getTableno()%></td>
                <td style="width:10%;text-align:center"><%=bean.getSeats()%></td>
                <td style="width:20%;text-align:center"><%=bean.getCost()%></td>
                 <td style="width:20%;text-align:center"><%=bean.getTimeslot()%></td>
                <td style="width:20%;text-align:center"><%=bean.getUsername()%></td>   
            </tr>
     <%}%>
     </table></td></tr></table>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:30px;width:100px;font-size:15px;background-color:LightSalmon;" type="submit" id="checkBtn"name="submit" value="cancel"/>  
 </td></tr></table>
 </form>
  </div>
</body>
</html>