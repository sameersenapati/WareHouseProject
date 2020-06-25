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
	<H3>WELCOME TO UOM TYPE EDIT PAGE</H3>
	<form:form action="update" method="POST" modelAttribute="uomType">
		<pre>
 Id:
 <form:input path="uomId" readonly="true" />

 Uom Type:
<form:select path="uomType">

<form:option value="">--select--</form:option>
<form:option value="Packing">Packing</form:option>
<form:option value="NoPacking">NoPacking</form:option>

</form:select>
Uom Model:
<form:input path="uomModel" />
Description:
<form:textarea path="udesc" />
<input type="submit" value="Update" />
 </pre>
	</form:form>
</body>
</html>