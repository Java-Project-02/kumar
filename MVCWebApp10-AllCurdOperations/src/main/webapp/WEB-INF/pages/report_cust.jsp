<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


 <br>
 <c:if test="${!empty msg}">
         <p align="center"><b>${msg} </b></p>
   </c:if>
<br>
<c:choose>
 <c:when test="${!empty reportData}">
   <table border="1" bgcolor="cyan" align="center">
     <tr>
       <th>cno</th><th>cname</th><th>caddr</th><th>cmblNo</th><th>billAmt</th><th>operations</th>
     </tr>
     <c:forEach var="dto" items="${reportData}">
       <tr>
         <td>${dto.cno}</td>
         <td>${dto.cname}</td>
         <td>${dto.caddr}</td>
         <td>${dto.cmblNo}</td>
         <td>${dto.billAmt}</td>
         <td><a title="edit" href="edit_cust.htm?cno=${dto.cno}">Edit</a> 
         <a title="delete" href="delete_cust.htm?cno=${dto.cno}" onClick="return confirm('Are you absolutely sure you want to delete?')">Delete</a> </td>
       </tr>
     </c:forEach>
   </table>
  <p align="center">
   <a title="insert" href="insert_cust.htm">INSERT</a>
     &nbsp; &nbsp; &nbsp; &nbsp;
 <a title="home" href="welcome.htm">HOME</a>
 </p> 
 </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center">No Data Found</h1>
  </c:otherwise>
</c:choose><br>
  
   <br>
   
 <p align="center"/>
