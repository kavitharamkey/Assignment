<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="employeeDetails.LocationBean"%>

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
<h2> Select the Location of your department: </h2>
<select name="location_id" id="location_id">
<option value="1" selected>Please select one </option>
<%
	List<LocationBean> locList = (List<LocationBean>)request.getAttribute("locList");
	if (locList == null){
		response.sendRedirect("DataError.jsp");
	}
	else{
		for (LocationBean locbean : locList){
%>
<option value= "<%=locbean.getLocationId() %>"> 
<%=locbean.getState() %> , <%=locbean.getCountry() %>
</option>
<%
} //Close For loop
} //close else condition
%>
</select>
<input type = "submit" value = "Get Employee Details" />
</form>
</body>
</html>