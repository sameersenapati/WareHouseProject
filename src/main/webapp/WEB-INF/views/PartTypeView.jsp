<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>WELCOME TO PARTTYPE VIEW PAGE</H3>
	<a href="excel?id=${ob.partId}"><img src="../resources/images/excel-logo.png" title="Convert To ExcelFormat" width="40" height="50"/></a>
	<a href="pdf?id=${ob.partId}"><img src="../resources/images/PDFicon.png" title="Convert To PdfFormat" width="40" height="50"/></a>
	
	<pre>
<table border="1">
<tr>
<th>ID</th>
				<td>${view.partId}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${view.partCode}</td>
</tr>
<tr>
<th>WIDTH</th>
				<td>${view.partWidth}</td>
</tr>
<tr>
<th>LENGTH</th>
				<td>${view.partLength}</td>
</tr>
<tr>
<th>HEIGHT</th>
				<td>${view.partHeight}</td>
</tr>
<tr>
<th>BASE COST</th>
				<td>${view.baseCost}</td>
</tr>

<tr>
<th>BASE CURRENCY</th>
				<td>${view.partCurrency}</td>
</tr>

<tr>
<th>DESCPRITION</th>
				<td>${view.partDesc}</td>
</tr>

</table>
</pre>
</body>
</html>