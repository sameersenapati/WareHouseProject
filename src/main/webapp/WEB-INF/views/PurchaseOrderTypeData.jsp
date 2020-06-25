<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<div class="card-header text-white bg-info" >
		<h1>Welcome to Purchase Order Data page</h1>
	</div>
<table class="table">
	<tr>
		<th>ID</th>
		<th>CODE</th>
		<th>STATUS</th>
		<th>VENDOR</th>
		<th>NOTE</th>
		<th colspan="2">  OPERATIONS  </th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.id}</td>
			<td>${ob.orderCode}</td>
			<td>${ob.status}</td>
			<td>${ob.vendor.userCode}</td>
			<td>${ob.note}</td>
			<td>
				<a href="parts?poId=${ob.id}" class="btn btn-primary">Add Parts</a>
			</td>
			<td>
			<c:choose>
				<c:when test="${'ORDERED' eq ob.status}">
					<a href="invoceOrder?poId=${ob.id}" class="btn btn-success">GENERATE INVOICE</a>
				</c:when>
				<c:when test="${'INVOICED' eq ob.status}">
					<a href="downloadInvoce?poId=${ob.id}" class="btn btn-info">DOWNLOAD INVOICE</a>
				</c:when>
				<c:when test="${'RECEVIED' eq ob.status}">
					<b class="text-success">ORDER IS USED IN GRN</b>
				</c:when>
				<c:otherwise>
					ORDER MUST BE PLACED
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
</div>
</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to PurchaseOrder Data Page</h3>
	
	<a href="excel"> <img src="../resources/images/excel-logo.png"
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
					<th>NUMBER</th>
					<th>QUALITY</th>
					<th>STATUS</th>
					<th>DESCRIPTION</th>
					<th colspan="4">OPTIONS</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.id}</td>
						<td>${ob.orderCode}</td>
						<td>${ob.referenceNumber}</td>
						<td>${ob.qualityCheck}</td>
						<td>${ob.status}</td>
						<td>${ob.description}</td>
						<td><a href="delete?pid=${ob.id}"><img
								src="../resources/images/delete.jpg" title="delete" width="50"
								height="40"></a></td>
						<td><a href="edit?pid=${ob.id}"><img
								src="../resources/images/edit.png" title="edit" width="30"
								height="30"></a></td>
						<td><a href="view?pid=${ob.id}"><img
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
	
</body>
</html> --%>