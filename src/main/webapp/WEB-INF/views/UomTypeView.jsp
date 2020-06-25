<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO UOM TYPE VIEW PAGE</h3>
	<a href="excel?id=${ob.uomId}"><img
		src="../resources/images/excel-logo.png" title="Convert To ExcelFormat"
		width="40" height="50" /></a>
	<a href="pdf?id=${ob.uomId}"><img
		src="../resources/images/PDFicon.png" title="Convert To PdfFormat"
		width="40" height="50" /></a>


	<pre>
<table border="1">
<tr>
<th>ID</th>
				<td>${view.uomId}</td>
</tr>
<tr>
<th>TYPE</th>
				<td>${view.uomType}</td>
</tr>
<tr>
<th>MODEL</th>
				<td>${view.uomModel}</td>
</tr>
<tr>
<th>DESCRIPTION</th>
				<td>${view.udesc}</td>
</tr>

</table>
</pre>
</body>
</html>