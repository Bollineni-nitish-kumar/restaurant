<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Not available</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:8%;width:100%;left:2%;">
<tr>

<td style="width:5%;text-align:right;"> <input style="width:60px;background-color:LightYellow;height:35px;" type="submit" name="submitna" value="back"/> </td>
<td style="width:5%;text-align:left;"> <input style="width:60px;background-color:LightGreen;height:35px;" type="submit" name="submitna" value="home"/> </td>
<td style="width:20%;text-align:right;"> <input style="width:60px;height:35px;background-color:OrangeRed;"type="submit" name="submitna" value="logout"/> </td> 
<td style="width:5%"></td>
</tr>
</table>
</form>

<table style="height:70%;width:70%; top: 0%; bottom:20%; left:15%; right:20%">
<tr style="height:30%"><td style="height:200px;"></td></tr>
<tr style="height:30%">
<td style="font-size:30px;text-align:center"><h4>Sorry, tables are not available for your requirements..</h4></td></tr>

</table>
</div>

</body>
</html>