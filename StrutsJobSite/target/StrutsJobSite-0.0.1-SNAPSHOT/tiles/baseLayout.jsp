<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body background="/images/welcomebckgrd.jpg">
<table border="1" cellspacing="2">
		<tr>
			<td height="200" colspan="3" width="1000"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td height="700" width="200" bgcolor="red"><tiles:insertAttribute name="left" /></td>
			<td height="700" width="600"><tiles:insertAttribute name="body" /></td>
			<td height="700" width="200" bgcolor="red"><tiles:insertAttribute name="right" /></td>
		</tr>
		<tr>
			<td height="100" colspan="3" width="1000"><tiles:insertAttribute name="footer" /></td>
		</tr>
</table>
</body>
</html>
