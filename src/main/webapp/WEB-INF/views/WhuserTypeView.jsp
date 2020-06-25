<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO WHUSER TYPE VIEW PAGE</h3>
	<a href="excel?id=${ob.userId}"><img src="../resources/images/excel.jpg"
		title="Convert To Excel Format" width="40" height="50" /></a> |
	<a href="pdf?id=${ob.userId}"><img src="../resources/images/PDFicon.png"
		title="Convert To Pdf Format" width="40" height="50" /></a>
<pre>
<table border="1" style="color: green">
<tr>
<th>ID</th>
				<td>${view.userId}</td>
</tr>
<tr>
<th>TYPE</th>
				<td>${view.userType}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${view.userCode}</td>
</tr>
<tr>
<th>USER FOR</th>
				<td>${view.userFor}</td>
</tr>
<tr>
<th>USER MAIL</th>
				<td>${view.userMail}</td>
</tr>
<tr>
<th>USER CONTACT</th>
				<td>${view.userContact}</td>
</tr>
<tr>
<th>USER ID TYPE</th>
				<td>${view.userIdtype}</td>
</tr>
<tr>
<th>IF OTHER</th>
				<td>${view.ifOther}</td>
</tr>
<tr>
<th>ID NUMBER</th>
				<td>${view.idNumber}</td>
</tr>
</table>
</pre>
</body>
${view}
</html>