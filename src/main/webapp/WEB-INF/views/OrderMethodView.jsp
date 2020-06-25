<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO ORDERMETHOD TYPE VIEW PAGE</h3>
	<a href="excel"> <img src="../resources/images/excel-logo.png"
		title="Convert To ExcelFormat" width="40" height="50" /></a>
	<a href="pdf"> <img src="../resources/images/PDFicon.png"
		title="Convert To Pdf Format" width="40" height="50" /></a>
	<pre>
<table border="1">
<tr>
<th>ID</th>
				<td>${view.orderId}</td>
</tr>
<tr>
<th>MODE</th>
				<td>${view.orderMode}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${view.orderCode}</td>
</tr>
<tr>
<th>ORDER TYPE</th>
				<td>${view.orderType}</td>
</tr>
<tr>
<th>ORDER ACCEPT</th>
				<td>${view.orderAcpt}</td>
</tr>
<tr>
<th>DESCRIPTION</th>
				<td>${view.description}</td>
</tr>
</table>
 </pre>
</body>
</html>