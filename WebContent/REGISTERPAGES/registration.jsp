<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#final{
width:100px;
height:20px;
}
td{
font-size:20px;
}



</style>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body style="background-color:HoneyDew">
<button style="text-align:left ;width:75px;height:35px" onclick="history.back()">Go Back</button>
<div align="center">
<h1>Register here</h1>
<form action="<%=request.getContextPath()%>/RegisterServlet" method="post">
<table>
<tr style="height:50px">
<td>First name</td>
<td><input type="text" name="first_name" maxlength="100"required/></td>
</tr>
<tr style="height:50px">
<td > Last name</td>
<td><input type="text" name="last_name" maxlength="100"required/></td>
</tr>
<tr style="height:50px">
<td>Mobile number</td>
<td> <input type="tel" name="mobile_no" maxlength="10"pattern="[1-9]{1}[0-9]{9}" required></td>
</tr>
<tr style="height:50px">
<td>Gmail</td>
<td><input type="email" name="gmail" maxlength="100" required /></td>
</tr>
<tr>
<td>gender</td>
<td> <input type="radio"  name="gender" value="Male" required>
  <label>Male</label>
  <input type="radio"  name="gender" value="Female" required>
  <label>Female</label>
  <input type="radio" name="gender" value="other" required>
  <label>others</label></td>
</tr>
<tr style="height:50px">
<td>User name</td>
<td><input type="text" name="user_name" maxlength="20"required/></td>
</tr>
<tr style="height:50px">
<td>password</td>
<td><input type="password" name="password" minlength="8" maxlength="32"required/></td>
</tr>
<tr style="height:50px">
<td colspan="2" style="text-align:center" ><input type="submit" id="final" value="submit"/></td>
</tr>
</table>
</form>

<% if(null!=request.getAttribute("status")){
	if((int)request.getAttribute("status")==1){%>
		<p style="color:red">username already exists</p>
	<%}else{%>
	    <p style="color:red">mail already exists!please login</p>
		
	<%}
}
	%>
</div>


</body>
</html>