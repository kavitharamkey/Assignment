<%@page import="com.mvc.employeeDetails.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Employee Details here</title>
</head>
<body>
<p align = "right">
<a href="Logout.jsp" >logout</a>
</p>
<h2> Employee Details you requested are: </h2>
<table>
<TR>
<TH>NAME</TH>
<TH>Employee ID</TH>
<TH>Department ID</TH>
<TH> Salary</TH>
</TR>
<%

List<EmployeeBean> empList = (List<EmployeeBean>)request.getAttribute("empList");
for (EmployeeBean empbean : empList){
%>
<TR>
<TD><%=empbean.getLname() %>,<%=empbean.getFname() %> </TD>
<TD><%=empbean.getEmpId() %></TD>
<TD><%=empbean.getDeptId() %></TD>
<TD><%=empbean.getSalary() %></TD>
</TR>
<%
} //Close For loop
%>
</table>
</body>
</html>