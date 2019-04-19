<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Insert Customer detials</h1>
 
   <script lang="JavaScript" src="validation.js">
   </script>
<center>
 <form:form method="POST" commandName="custCmd" onsubmit="return validate(this)">

Customer no::<form:input path="cno"/><form:errors path="cno"/><span id="cno.err"></span><br>  
Customer name::<form:input path="cname"/><form:errors path="cname"/><span id="cname.err"></span><br>  
Customer adress::<form:input path="caddr"/><form:errors path="caddr"/><span id="caddr.err"></span><br>  
Customer mblno::<form:input path="cmblNo"/><form:errors path="cmblNo"/><span id=cmblNo.err></span><br>  
Customer billAmt::<form:input path="billAmt"/><form:errors path="billAmt"/><span id=billAmt.err></span><br>  
 
 

  <input type="submit" value="Register Customer">
</form:form>
</center>

<p align="center">
 <a title="home" href="welcome.htm">Home</a>
 &nbsp;&nbsp;&nbsp;&nbsp;
 <a title="back" href="cust_report.htm">Back</a>
 </p>
