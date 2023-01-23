<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="beans.Addbean"%>
    <%@page import="java.io.ByteArrayOutputStream" %>
    <%@page import="java.io.ObjectOutputStream" %>
    <%@page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<script src="./libs/jquery/1.10.1/jquery.min.js"></script>
<style>
div{
height:90vh;
}
</style>
<meta charset="UTF-8">
<title>Remove table</title>
</head>
<body style="background-color:HoneyDew">
<script type="text/javascript">
    function fncport(controlid, o1,o2,o3) {
        var control = document.getElementById(controlid);
        var obj1 = document.getElementById(o1);
         var obj2=document.getElementById(o2);
         var obj3=document.getElementById(o3);
        obj1.disabled = !control.checked;
        obj2.disabled = !control.checked;
        obj3.disabled = !control.checked;
    }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div align="center">
<table style="float:left;height:8%;width:5%;left:2%;">
<tr>
<td style="width:100%;text-align:left;"><button style="width:60px;background-color:LightGreen;height:35px;" onclick="history.back()">Back</button>  </td>
</tr>
</table>

<form action="<%=request.getContextPath() %>/AdminredirectServlet" method="post">
<table style="height:8%;width:90%;left:10%;">
<tr>
<td style="width:5%;text-align:left;"> <input style="width:60px;background-color:LightGreen;height:35px;" type="submit" name="submit" value="home"/> </td>
<td style="width:20%;text-align:right;"> <input style="width:60px;height:35px;background-color:OrangeRed;"type="submit" name="submit" value="logout"/> </td> 
<td style="width:3%"></td>
</tr>
</table>
</form>
<table style="height:10%;width:90%;">
<tr style="height:10%">
<td colspan="5" style="width:25%;text-align:center;"><h4>Displaying table details</h4></td>
</tr>
</table>
<table style="height:5%;width:70%;left:15%; right:10%">
 <tr bgcolor="00FF7F">
<th style="width:25%;text-align:center"><b>select to modify</b></th>
<th style="width:25%;text-align:center"><b>Table Number</b></th>
<th style="width:25%;text-align:center"><b>Number of seats</b></th>
<th style="width:25%;text-align:center"><b>cost per hour</b></th>

 </tr>
</table>
<form action="<%=request.getContextPath() %>/RemoveServlet" method="post">
<%List<Addbean> std = 
            (List<Addbean>) request.getAttribute("tabledata");
        for(Addbean bean:std){
        	final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	final ObjectOutputStream oos = new ObjectOutputStream(baos);
        	oos.writeObject(bean);
        	oos.flush();
        	final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));%>
            <input type="hidden" name="<%= "MY_JAVA_OBJECT" %>" value="<%= result%>"/>
             <table style="height:5%;width:70%;left:15%; right:10%">
            <tr style="background-color:Cornsilk">
                <td style="width:25%; height:100px;text-align:center"><input class="userCheckbox"style="height:25px;width:25px;" type="checkbox" id="selectedTables_<%=bean.getTableid()%>"name="selectedTables"onclick="fncport('selectedTables_<%=bean.getTableid()%>', 'input1_<%=bean.getTableid()%>','input2_<%=bean.getTableid()%>','input3_<%=bean.getTableid()%>');" value="<%=bean.getTableid()%>"/></td>
                <td style="width:25%;text-align:center"><input style="height:25px;width:100px;" type="number" min="0" max="5000"id="input1_<%=bean.getTableid()%>" name="input1_<%=bean.getTableid()%>"value="<%=bean.getTableno()%>" disabled="disabled"/></td>
                <td style="width:25%;text-align:center"><input style="height:25px;width:100px;" type="number" min="0" max="5000" id="input2_<%=bean.getTableid()%>" name="input2_<%=bean.getTableid()%>"value="<%=bean.getNoseats()%>"disabled="disabled"/></td>
                <td style="width:25%;text-align:center"><input style="height:25px;width:100px;" type="number" step=0.01 id="input3_<%=bean.getTableid()%>" name="input3_<%=bean.getTableid()%>"value="<%=bean.getPrice()%>"disabled="disabled"/></td>
            </tr>
            </table>
     <%}%>
     <table style="height:20%;width:70%;left:15%;right:10%">
     <tr>
  <td style="font-size:30px;text-align:center"><input style="height:30px;width:100px;font-size:15px;background-color:LightSalmon;" type="submit" id="checkBtn"name="submit" value="save changes"/>  
 </td></tr></table>
</form>
</div>

</body>
</html>