<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.full{
  height: 90vh;
}
</style>
<meta charset="UTF-8">
<title>booking table</title>
</head>
<body style="background-color:LightCyan">
<div class="full"> 
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:8%;width:100%;left:2%;">
<tr>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="back"/></td>
<td style="width:50%;text-align:center;"><h3>check based on seats or table number</h3></td>
<td style="width:25%;text-align:center;"><input style="width:60px;height:35px;"type="submit" name="submit" value="logout"/></td> 

</tr></table>
</form>
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
<table style="height:90%;width:50%;float:left;position: absolute; top:10%; bottom:5%; left:2%;right:0;">
   <tr style="height:10%"></tr>
    <tr style="height:5%">
 <td style="width:50%;vertcal-align:bottom;font-size:25px;text-align:right">select number of seats required:</td>
 <td style="text-align:left">
 <select style="vertcal-align:bottom;width:200px;height:40px;" name="seats" required>
      <option style="font-size:20px" value="2">2</option>
      <option style="font-size:20px" value="4">4</option>
      <option style="font-size:20px" value="6">6</option>
 </select></td>
 </tr>
 <tr style="height:2%">
 <td colspan="2" style="vertical-align:top;font-size:15px;text-align:center">if there is no exact seats select nearest ones</td></tr>
   <tr style="height:5%">
 <td style="width:30%;vertcal-align:top;font-size:25px;text-align:right">select the time slot:</td>
 <td style="text-align:left">
 <select style="width:200px;vertcal-align:top;height:40px;" name="time" required>
      <option style="font-size:20px" value="9">9 AM</option>
      <option style="font-size:20px" value="10">10 AM</option>
      <option style="font-size:20px" value="11">11 AM</option>
       <option style="font-size:20px" value="12">12 pM</option>
      <option style="font-size:20px" value="13">1 PM</option>
      <option style="font-size:20px" value="14">2 PM</option>
      <option style="font-size:20px" value="15">3 pM</option>
      <option style="font-size:20px" value="16">4 PM</option>
      <option style="font-size:20px" value="17">5 PM</option>
      <option style="font-size:20px" value="18">6 pM</option>
      <option style="font-size:20px" value="19">7 PM</option>
      <option style="font-size:20px" value="20">8 PM</option>
      <option style="font-size:20px" value="21">9 PM</option>
  </select></td>
 </tr>
  <tr style="height:3%">
 <td colspan="2" style="vertical-align:top;font-size:15px;text-align:center">one slot is valid for one hour</td></tr>
  <tr style="height:5% ">
<td colspan="2" style="text-align:center"><input style="height:50px;width:100px;font-size:20px;background-color:Orange" type="submit" name="submit" value="check"/></td>
 </tr>
 <tr style="height:60%"></tr>
 
  </table>
  </form>
<form action="<%=request.getContextPath() %>/AvailabilityServlet" method="post">
 <table style="float: left;height:90%;width:50%;position:absolute;top:10%; bottom:5%;right:0;left:53%;">
   <tr style="height:10%"></tr>
    <tr style="height:5%">
 <td style="width:50%;vertcal-align:bottom;font-size:25px;text-align:right">Enter the table number:</td>
 <td style="text-align:left"><input style="width:185px;height:35px;"type="num" name="table_no" min="0" max="9999" required/></td>
 </tr>
  <tr style="height:5%">
 <td style="width:30%;vertcal-align:top;font-size:25px;text-align:right">select the time slot:</td>
 <td style="text-align:left">
 <select style="width:200px;vertcal-align:top;height:40px;" name="time" required>
      <option style="font-size:20px" value="9">9 AM</option>
      <option style="font-size:20px" value="10">10 AM</option>
      <option style="font-size:20px" value="11">11 AM</option>
       <option style="font-size:20px" value="12">12 pM</option>
      <option style="font-size:20px" value="13">1 PM</option>
      <option style="font-size:20px" value="14">2 PM</option>
      <option style="font-size:20px" value="15">3 pM</option>
      <option style="font-size:20px" value="16">4 PM</option>
      <option style="font-size:20px" value="17">5 PM</option>
      <option style="font-size:20px" value="18">6 pM</option>
      <option style="font-size:20px" value="19">7 PM</option>
      <option style="font-size:20px" value="20">8 PM</option>
      <option style="font-size:20px" value="21">9 PM</option>
  </select></td>
 </tr>
  <tr style="height:3%">
 <td colspan="2" style="vertical-align:top;font-size:15px;text-align:center">one slot is valid for one hour</td></tr>
  <tr style="height:5% ">
<td colspan="2" style="text-align:center"><input style="height:50px;width:100px;font-size:20px;background-color:Orange" type="submit" name="submit" value="check table"/></td>
 </tr>
 <tr style="height:60%"></tr>
</table>
</form>
</div>
</body>
</html>