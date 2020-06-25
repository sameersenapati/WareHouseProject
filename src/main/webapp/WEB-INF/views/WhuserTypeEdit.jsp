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
	<H3>WELCOME TO WHUSER TYPE EDIT PAGE</H3>
	<form:form action="update" method="POST" modelAttribute="whuserType">
		<pre>
User Id:
 <form:input path="userId" readonly="true" />

User Type:
<form:radiobutton path="userType" value="vendor" />
<form:radiobutton path="userType" value="customer" />
UserCode:
<form:input path="userCode" />
UserFor:
<form:input path="userFor" />
User Mail:
<form:input path="userMail" />
UserContact:
<form:input path="userContact" />
User Id Type:
 <form:select path="userIdtype">
<form:option value="">--select--</form:option>
<form:option value="PANCARD">PANCARD</form:option>
<form:option value="AADHAR">AADHAR</form:option>
<form:option value="VOTERID">VOTERID</form:option>
<form:option value="OTHER">OTHER</form:option>
</form:select>
If Other:
<form:input path="ifOther" />
Id Number:
<form:input path="idNumber" />
<input type="submit" value="Update" />
 </pre>
	</form:form>
</body>
</html>