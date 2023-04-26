<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home page</title>
<style>
body{
background-image:url("projectimage.jpg");
backgroung-repeat:no-repeat;
background-size:cover;

}
</style>
</head>
<body>
<%
int check=0;
try {
	
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    if (session.getAttribute("Username")==null) {
    	request.setAttribute("details",1);
    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        //response.sendRedirect("index.jsp");
        rd.forward(request,response);
    }
    else if((String)session.getAttribute("role")!=null){
    	String rol=(String)session.getAttribute("role");
    	if(rol.equals("user")||rol.equals("admin")){
    	check=1;
    	}
    }
}
catch(Exception ex) {
	out.println(ex);
}
if(check==1){%>
<div align="center">
<form action="<%=request.getContextPath() %>/ClassifyServlet" method="post">
<table style="height:70%;width:70%; position: absolute; top: 0%; bottom:20%; left:15%; right:20%">
<tr style="height:25% ;width:100%">
<td colspan="3" style="text-align:center"><h1> welcome2 <% 
String name=(String)session.getAttribute("Username"); 
out.print(name); 
%> </h1>
</td></tr>
<tr style="height: 50%;">

<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px;background-color:PapayaWhip;" type="submit" name="submit" value="book table"/></td>
<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px; background-color:PapayaWhip;" type="submit" name="submit" value="view booking"/></td>
<td style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px; background-color:PapayaWhip;" type="submit" name="submit" value="view availability"/></td>
</tr>
<tr style="height:25% ">
<td colspan="2" style="text-align:center"><input style="border-radius:12px;height:100px;width:200px;font-size:25px;background-color:PapayaWhip;" type="submit" name="submit" value="view my details"/></td>
<td colspan="1" style="text-align:left"><input style="height:50px;width:100px;font-size:20px;background-color:tomato;" type="submit" name="submit" value="logout"/></td>
 </tr>
</table>
</form>
</div>
<%}else{ %>
<div align="center">
<h3>you dont have access to this page</h3>
</div>
<%} %>

</body>
</html>