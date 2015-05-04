<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To select the  Branch Locations</title>
</head>
<body>
<p align = "right">
<a href="Logout.jsp" >logout</a>
</p>
<form action = "ControllerServlet" method = "POST">
<h2> Select the Location of your department: </h2> <BR>
<c:out value="My new JSTL excercise"/>
<select name="location_id" id="location_id">
<option value="1" selected>Please select one </option>

<c:set var="locList" scope="request" value="${locList}"/>
<c:if test="${empty locList}">
   <% System.out.println("empty list"); %>
   <c:redirect context = "/DataError.jsp" />
</c:if>
<jsp:useBean id="locBean"	class="employeeDetails.LocationBean">
</jsp:useBean>
<c:forEach var="locBean" items="${locList}">
   <option value='<jsp:getProperty name="locBean" property="locationId"/>'>
          <jsp:getProperty name="locBean" property="state"/>,
          <jsp:getProperty name="locBean" property="country"/>
   </option>  
</c:forEach>

</select>
<input type = "submit" value = "Get Employee Details" />
</form>
</body>
</html>