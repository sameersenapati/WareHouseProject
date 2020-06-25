<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>WELCOME TO ORDERMETHOD EDIT PAGE</H3>
	<form:form action="update" method="POST" modelAttribute="orderMethod">
		<pre>
Order Id:
 <form:input path="orderId" readonly="true" />

OrderMode:
<form:radiobutton path="orderMode" value="sale" />SALE
<form:radiobutton path="orderMode" value="purchase" />PURCHASE
OrderCode:
<form:input path="orderCode" />
OrderType:
<form:select path="orderType">
<form:option value="">--select--</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FCFO">FCFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
OrderAccept:
<form:checkbox path="orderAcpt" value="MultiModel" />MutiModel
<form:checkbox path="orderAcpt" value="AcceptReturn" />AcceptReturn
Description:
<form:textarea path="description" />
<input type="submit" value="Update" />
 </pre>
	</form:form>
</body>
</html>