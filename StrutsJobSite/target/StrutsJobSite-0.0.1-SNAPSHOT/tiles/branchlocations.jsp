<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Openings</title>
</head>
<body>
<h1>We have branches in these locations</h1><BR>  
<BR>
<table>
<OL>
<s:iterator value="locList">
<LI>
<s:property value="street"/>,<BR>
<s:property value="city"/>,<s:property value="country"/>
</LI>
</s:iterator>
</OL>
</table>
</body>
</html>