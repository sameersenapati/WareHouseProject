<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>WELCOME TO SHIPMENT TYPE VIEW PAGE</H3>
			</div>

			<a href="excel?id=${ob.shipId}"><img src="../resources/images/excel-logo.png" title="Convert To ExcelFormat" width="40" height="50" /></a>
		    <a href="pdf?id=${ob.shipId}"> <img src="../resources/images/PDFicon.png" title="Convert To PdfFormat" width="40" height="50" /></a>
					<pre>                                                   
			<table border="1">
				<tr>
					<th>ID</th>
					<td>${view.shipId}</td>
				</tr>
				<tr>
					<th>MODE</th>
					<td>${view.shipMode}</td>
				</tr>
				<tr>
					<th>CODE</th>
					<td>${view.shipCode}</td>
				</tr>
				<tr>
					<th>ENABLE</th>
					<td>${view.enbShip}</td>
				</tr>
				<tr>
					<th>GRADE</th>
					<td>${view.shipGrade}</td>
				</tr>
				<tr>
					<th>DESCRIPTION</th>
					<td>${view.shipDesc}</td>
				</tr>

			</table>
			</pre>
		</div>
	</div>
</body>
</html>