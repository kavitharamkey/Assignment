<%@page import="com.kavitha.struts.employeeDetails.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Employee Details here</title>
</head>
<body>
<h2>Hello <s:property value="userName"/>, Employee Details you requested are: </h2>

<BR>
<table>
<TR>
<TH>NAME</TH>
<TH>Employee ID</TH>
<TH>Department ID</TH>
<TH> Salary</TH>
</TR>
</table>


</body>
</html>