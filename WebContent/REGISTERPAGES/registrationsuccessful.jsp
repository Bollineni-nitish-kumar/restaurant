<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registrationsuccess</title>
</head>
<body>
<div align="center">
<h1>  Registration successful.....</h1><br>
<form action="<%=request.getContextPath()%>/LoginredirectServlet" method="post">
<input style="font-size:20px;width:100px;height:30px;" type="submit" value="login" name="submit"/>
</form>
</div>
</body>
</html>