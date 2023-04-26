<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reset page</title>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath() %>/ResetServlet" method="get">
<h3> please enter gmail to reset password</h3>
<table>
<tr>
<td>enter gmail:</td>
<td><input type="email" name="gmail" maxlength="100"required/></td>
</tr>
<tr>
<td colspan="2" style="text-align:center"><input type="submit" name="submit" value="submit"/></td>
</tr>
</table>
</form>
<%if(request.getAttribute("invalidMail")!=null&&(boolean)request.getAttribute("invalidMail")){ %>
<p style="color:red">please enter valid email</p>
<%} %>
</div>
</body>
</html>