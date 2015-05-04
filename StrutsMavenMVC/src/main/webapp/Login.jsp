<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application</title>
</head>
<body bgcolor="FFCCFF">
	<s:form action="login" method="post">
		<s:textfield name="userName" label="DB USER NAME" />
		<s:password name="password" label="DB PASSWORD" />
		<s:submit value="Login Oracle HR Schema" />
	</s:form>
</body>
</html>