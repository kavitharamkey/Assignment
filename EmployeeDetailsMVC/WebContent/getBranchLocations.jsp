<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="employeeDetails.LocationBean"%>
<%@page import="employeeDetails.GetLocationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "getEmployeeDetails" method = "POST">
<h2> Select the Location of your department: </h2>
<select name="location_id">
<%
Connection con = (Connection)session.getAttribute("dbcon");
GetLocationDAO getLocationDAO = new GetLocationDAO(con);
List<LocationBean> locList = getLocationDAO.locationList;
if (locList == null)
   out.println("Cannot Establish connection with Database, Please Try Again Later");
else{
	for (LocationBean locbean : locList){

%>
<option value=<%=locbean.getLocationId() %>> 
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