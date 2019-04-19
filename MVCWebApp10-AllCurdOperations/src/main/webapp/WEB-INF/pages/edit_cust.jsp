<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Edit Customer detials</h1>
  <center>
<form:form method="POST"  commandName="custCmd">
  Student number:: <form:input path="cno" disabled="true"/> <br>
  Student name:: <form:input path="cname"/>  <br>
  Student address:: <form:input path="caddr"/><br>
  Student Course:: <form:input path="cmblNo"/><br>
   Student Course:: <form:input path="billAmt"/><br>
  <input type="submit" value="UpdateCustomer">
</form:form>
</center>
<p align="center">
 <a title="home" href="welcome.htm">home</a>
 &nbsp;&nbsp;&nbsp;&nbsp;
 <a title="back" href="cust_report.htm">Back</a>
 </p>
