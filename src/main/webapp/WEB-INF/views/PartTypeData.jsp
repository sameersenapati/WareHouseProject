<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to PartType Data Page</h3>
	
	<a href="excel"><img src="../resources/images/excel-logo.png"
		title="Convert To ExcelFormat" width="40" height="50" /></a>
	<a href="pdf"> <img src="../resources/images/PDFicon.png"
		title="Convert To Pdf Format" width="40" height="50" />
	</a>

	<c:choose>
		<c:when test="${!empty list}">
			<table border="1" style="color: brown">

				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>WIDTH</th>
					<th>LENGTH</th>
					<th>HEIGHT</th>
					<th>COST</th>
					<th>CURRENCY</th>
					<th>DESCRIPTION</th>
					<th>UOM</th>
					<th>ORDER METHOD CODE</th>
					<th colspan="4">OPTIONS</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.partId}</td>
						<td>${ob.partCode}</td>
						<td>${ob.partWidth}</td>
						<td>${ob.partLength}</td>
						<td>${ob.partHeight}</td>
						<td>${ob.baseCost}</td>
						<td>${ob.partCurrency}</td>
						<td>${ob.partDesc}</td>
						<td>${ob.uomOb.uomModel}</td>
						<td>${ob.omPurchaseOb.orderCode}</td>
						<td>${ob.omSaleOb.orderCode}</td>
						<td><a href="delete?pid=${ob.partId}"><img
								src="../resources/images/delete.jpg" title="delete" width="50"
								height="40"></a></td>
						<td><a href="edit?pid=${ob.partId}"><img
								src="../resources/images/edit.png" title="edit" width="30"
								height="30"></a></td>
						<td><a href="view?pid=${ob.partId}"><img
								src="../resources/images/view.png" title="view" width="40"
								height="40"> </a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4>NO DATA FOUND!!</h4>
		</c:otherwise>
	</c:choose>
	
	${message}

</body>

</html>
