<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cancel success</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/HomeredirectServlet" method="post">
<table style="height:5%;width:90%;">
<tr style="height:10%">
<td colspan="2" style="width:25%;text-align:left;"><input style="width:60px;background-color:LightGreen;height:35px;"type="submit" name="submit" value="home"/></td>
<td colspan="3" style="width:25%;text-align:right;"><input style="width:60px;background-color:OrangeRed;height:35px;"type="submit" name="submit" value="logout"/></td> 
</tr>
</table>
</form>
<table style="height:70%;width:70%;position:absolute;top: 0%; bottom:20%; left:15%; right:20%">
<tr style="height:30%">
<td style="font-size:30px;text-align:center"><h4>Hello <% 
String name=(String)session.getAttribute("Username"); 
out.print(name); %> ! your cancellation is successful...</h4></td></tr>
</table>
</div>
</body>
</html>