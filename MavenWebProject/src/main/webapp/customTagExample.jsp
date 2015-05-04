<%@ taglib prefix="usr" uri="/WEB-INF/tlds/ReplaceDescriptor.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSP Custom Taglib example: Substr function</title>
</head>
<body>
    REPLACE(GOODMORNING, GOODEVENING) is
	<font color="blue">
	<usr:replace input="GOODMORNING"	output="GOODEVENING" />
	</font>

</body>
</html>