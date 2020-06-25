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
				<H3>WELCOME TO PARTTYPE EDIT PAGE</H3>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="partType">

					<div class="row">
						<div class="col-4">
							<label for="partId"> ID</label>
							<div class="col-4">
								<form:input path="partId" readonly="true" />
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>
					</div>



					<div class="row">
						<div class="col-4">
							<label for="partCode">PART CODE</label>
						</div>
						<div class="col-4">
							<form:input path="partCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partWidth">PART WIDTH</label>
						</div>
						<div class="col-4">
							<form:input path="partWidth" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partLength">PART LENGTH</label>
						</div>
						<div class="col-4">
							<form:input path="partLength" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partHeight">PART HEIGHT</label>
						</div>
						<div class="col-4">
							<form:input path="partHeight" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partBaseCost">BASE COST</label>
						</div>
						<div class="col-4">
							<form:input path="partBaseCost" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="partBaseCurrency">BASE CURRENCY</label>
						</div>
						<div class="col-4">
							<form:select path="partBaseCurrency" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>

						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<input type="submit" value="Update" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	${message}
</body>
</html>
<%-- 	<H2>WELCOME TO PART TYPE EDIT PAGE</H2>
	<form:form action="update" method="POST" modelAttribute="partType">
		<pre>
Part Id:
 <form:input path="partId" readonly="true" />
Part Code:
 <form:input path="partCode" />
WIDTH:
<form:input path="partWidth" />
LENGTH:
<form:input path="partLength" />
HEIGHT:
<form:input path="partHeight" />
BASE COST:
<form:input path="baseCost" />
BASE CURRENCY:
<form:select path="partCurrency">
<form:option value="">--select--</form:option>
<form:option value="INR">INR</form:option>
<form:option value="USD">USD</form:option>
<form:option value="AUS">AUS</form:option>
<form:option value="ERU">ERU</form:option>
</form:select>
Description:
<form:textarea path="partDesc" />
<input type="submit" value="Update" />
 </pre>
	</form:form>
 --%>