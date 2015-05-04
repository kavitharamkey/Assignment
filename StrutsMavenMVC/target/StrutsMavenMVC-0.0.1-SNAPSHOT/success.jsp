<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Successful</title>
    </head>
    <body bgcolor="FFCCFF">
    	<s:form action="getDetails" method="post">
        	<H1>Hello, <s:property value="userName"/></H1> <BR><H2> Welcome to the next page</H2>
        	<s:submit value="Get Employee Details from HR Schema"></s:submit>
		</s:form>
    </body>
</html>

