<%@page import="com.kavitha.struts.employeeDetails.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Employee Details here</title>
</head>
<body>
<h2> Employee Details you requested are: </h2>
count:${empList.size()}
<BR>
<table>
<TR>
<TH>NAME</TH>
<TH>Employee ID</TH>
<TH>Department ID</TH>
<TH> Salary</TH>
</TR>
<jsp:useBean id="empbean"	class="com.kavitha.struts.employeeDetails.EmployeeBean">
</jsp:useBean>
<c:forEach var="empbean" items="${empList}">
  <TR>
	<TD><jsp:getProperty name="empbean" property="name"/> </TD>
	<TD><jsp:getProperty name="empbean" property="empId"/></TD>
	<TD><jsp:getProperty name="empbean" property="deptId"/></TD>
	<TD><jsp:getProperty name="empbean" property="salary"/></TD>
  </TR>
</c:forEach>
</table>


</body>
</html>