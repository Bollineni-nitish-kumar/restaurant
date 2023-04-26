<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reset password</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/ResetServlet" method="get">
<table>
<tr>
<td> <input type="hidden" name="token"/></td>
</tr>
<tr>
<td><input type="hidden" name="gmail"/>
<tr>
<td><input type="submit" name="submit" value="reset"></td>
</tr>
</table>
</form>
</div>
</body>
</html>