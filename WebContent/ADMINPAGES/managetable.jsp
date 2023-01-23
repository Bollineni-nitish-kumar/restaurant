<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manage tables</title>
<style>
</style>
</head>
<body style="background-color:Aquamarine">
<div align="center">
<form action="<%=request.getContextPath() %>/AdminredirectServlet" method="post">
<table style="height:5%;width:90%;">
<tr style="height:10%">
<td  colspan="2" style="width:5%;text-align:left;"><input style="width:60px;height:35px;"type="submit" name="submit" value="home"/></td>
<td colspan="3" style="width:25%;text-align:right;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 
</tr>
</table>
</form>
<form action="<%=request.getContextPath() %>/ManageServlet" method="post">
<table style="height:70%;width:70%; position: absolute; top: 0%; bottom:20%; left:15%; right:20%">
<tr style="height:25% ;width:100%">
<td colspan="2" style="text-align:center">
</td></tr>
<tr style="height: 50%;">

<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px;background-color:PapayaWhip;" type="submit" name="submit" value="Add table"/></td>
<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px; background-color:PapayaWhip;" type="submit" name="submit" value="Remove table"/></td>
<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px;background-color:PapayaWhip;" type="submit" name="submit" value="modify details"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>