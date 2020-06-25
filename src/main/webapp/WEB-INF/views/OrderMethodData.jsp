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
	<h3>Welcome to OrderMethod Data Page</h3>
	<a href="excel"> <img src="../resources/images/excel-logo.png"
		title="Convert To ExcelFormat" width="40" height="50" />
	</a>
	<a href="pdf"> <img src="../resources/images/PDFicon.png"
		title="Convert To Pdf Format" width="40" height="50" />
	</a>
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1">

				<tr>
					<th>ORDER ID</th>
					<th>ORDER MODE</th>
					<th>OREDR CODE</th>
					<th>ORDER TYPE</th>
					<th>ORDER ACCEPT</th>
					<th>NOTE</th>
					<th colspan="4">OPERATIONS</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.orderId}</td>
						<td>${ob.orderMode}</td>
						<td>${ob.orderCode}</td>
						<td>${ob.orderType}</td>
						<td>${ob.orderAcpt}</td>
						<td>${ob.description}</td>
						<td><a href="delete?oid=${ob.orderId}"><img
								src="../resources/images/delete.jpg" title="delete" width="50"
								height="40"></a></td>
						<td><a href="edit?oid=${ob.orderId}"><img
								src="../resources/images/edit.png" title="edit" width="30"
								height="30"></a></td>
						<td><a href="view?oid=${ob.orderId}"><img
								src="../resources/images/view.png" title="view" width="40"
								height="40"></a></td>
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