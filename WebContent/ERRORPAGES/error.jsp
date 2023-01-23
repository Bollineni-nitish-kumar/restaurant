<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
<p>Hi There, error code is <%=response.getStatus() %></p><br>
<p>Please go to <a href="LOGINPAGES/index.jsp">login page</a></p>
</body>
</html>