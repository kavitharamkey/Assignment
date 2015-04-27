<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.sql.Connection"%>
<%@page import="employeeDetails.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!private static Logger log = Logger.getLogger("Logout.jsp"); %>
<%
Connection con = (Connection)session.getAttribute("dbcon");
log.debug(session.getId()+" Logout clicked, so i am invalidating session and closing DB connection");
session.invalidate();
if (con != null)
	DBConnection.closeConnection(con);
%>
<h2>Successfully logged out</h2>
<BR>
<%@include  file="index.html" %>
</body>
</html>