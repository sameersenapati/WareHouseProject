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
	<h2>Welcome to UOM Data Page</h2>
	<a href="excel"><img src="../resources/images/excel-logo.png"
	 width="30" height="40" /> 
		</a>
	<a href="pdf"> <img src="../resources/images/PDFicon.png"
		 width="30" height="40" /> 
		</a>
	<c:choose>

		<c:when test="${!empty list}">
			<table border="1" style="color: blue">
				<tr>
					<th>UOM TYPE</th>
					<th>UOM MODEL</th>
					<th>NOTE</th>
					<th colspan="4">OPTIONS</th>
				</tr>

				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.uomId}</td>
						<td>${ob.uomType}</td>
						<td>${ob.uomModel}</td>
						<td>${ob.udesc}</td>
						<td><a href="delete?uid=${ob.uomId}"> <img
								src="../resources/images/delete.jpg" width="50"
								height="40"></a></td>
						<td><a href="edit?uid=${ob.uomId}"><img
								src="../resources/images/edit.png" width="50"
								height="40"></a></td>
						<td><a href="view?uid=${ob.uomId}"><img
								src="../resources/images/view.png" width="50"
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