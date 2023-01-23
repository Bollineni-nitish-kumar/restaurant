<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove success</title>
</head>
<body>
<div align="center">

<form action="<%=request.getContextPath() %>/RemoveServlet" method="post">
<table style="float:left;height:8%;width:5%;">
<tr>
<td style="width:100%;text-align:left;"><input type="submit" style="width:60px;background-color:LightGreen;height:35px;" name="submit" value="back"/></td>
</tr>
</table></form>
<form action="<%=request.getContextPath() %>/AdminredirectServlet" method="post">
<table style="float:left;height:8%;width:90%;left:10%;">
<tr>
<td style="width:5%;text-align:left;"> <input style="width:60px;background-color:LightGreen;height:35px;" type="submit" name="submit" value="home"/> </td>
<td style="width:20%;text-align:right;"> <input style="width:60px;height:35px;background-color:OrangeRed;"type="submit" name="submit" value="logout"/> </td> 
<td style="width:3%"></td>
</tr>
</table>
</form>
<table style="height:70%;width:70%; position: absolute; top: 0%; bottom:20%; left:15%; right:20%">
<tr style="height:30%">
<td style="font-size:30px;text-align:center"><h4>Removing a table is successful</h4></td></tr>
</table>
</div>
</body>
</html>