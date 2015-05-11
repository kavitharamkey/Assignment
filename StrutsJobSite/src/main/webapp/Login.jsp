<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login to Job Site</title>
</head>
<body background="images/background.jpg"">
<BR><BR><BR>
<CENTER>
	<h2>Login to Job Portal</h2><BR><BR>
	<s:form action="login" method="post">
		<h3><s:textfield name="userName" label="USERNAME"/>
		<s:textfield name="password" label="PASSWORD"/>
		<s:submit label="LOGIN" />	</h3>
	</s:form> 
</CENTER>
</body>
</html>