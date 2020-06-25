<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Grn Data Page</h1>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class="bg-warning ">
						<td>GRNCODE</td>
						<td>GRNTYPE</td>
						<td>NOTE</td>
						<td colspan='2'>OPERATIONS</td>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.grnCode}" /></td>
							<td><c:out value="${ob.grnType}" /></td>
							<td><c:out value="${ob.description}" /></td>
							<td><a href='delete?id=${ob.grnId}'>DELETE</a></td>
							<td><a href='edit?id=${ob.grnId}'>EDIT</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
</body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<%-- <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO GRN DATA PAGE</h3>
	<a href="excel"><img src="../resources/images/excel-logo.png"
		title="Convert To ExcelFormat" width="40" height="50" /></a>
	<a href="pdf"> <img src="../resources/images/PDFicon.png"
		title="Convert To Pdf Format" width="40" height="50" />
	</a>

	<c:choose>
		<c:when test="${!empty list}">
			<table border="1" style="color: brown">
				<tr>
					<th>GRN ID</th>
					<th>GRN CODE</th>
					<th>GRN TYPE</th>
					<th>DESCRIPTION</th>
					<th colspan="4">OPTIONS</th>
				</tr>

				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.grnId}</td>
						<td>${ob.grnCode}</td>
						<td>${ob.grnType}</td>
						<td>${ob.description}</td>
					</tr>
					<td><a href="delete?gid=${ob.grnId}"><img
							src="../resources/images/delete.jpg" title="delete" width="50"
							height="40"></a></td>
					<td><a href="edit?gidid=${ob.grnId}"><img
							src="../resources/images/edit.png" title="edit" width="30"
							height="30"></a></td>
					<td><a href="view?gid=${ob.grnId}"><img
							src="../resources/images/view.png" title="view" width="40"
							height="40"> </a></td>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4>NO DATA FOUND!!</h4>
		</c:otherwise>
		${message}
	</c:choose>
</body>
</html> --%>