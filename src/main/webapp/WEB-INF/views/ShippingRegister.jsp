<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div class="cadr-header bg-primary text-white text-uppercase">
				<h1>WELCOME TO SHIPPING REGISTER PAGE</h1>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="shipping">
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="shippingCode">SHIPPING CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shippingCode" id="shippingCode"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="shippingCodeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="shippingRefNum">SHIPPING REFNUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="shippingRefNum" id="shippingRefNum"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="shippingRefNumError"></span>
						</div>
					</div>

					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="courierRefNum">COURIER REFNUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="courierRefNum" id="courierRefNum"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="courierRefNumError"></span>
						</div>
					</div>

					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="contactDetails">CONTACT DETAILS</label>
						</div>
						<div class="col-4">
							<form:input path="contactDetails" id="contactDetails"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="contactDetailsError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="saleOrderCode">SALE ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="saleOrderCode" id="saleOrderCode"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="saleOrderCodeError"></span>
						</div>
					</div>

					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" id="description"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="descriptionError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="billToAddress">BILL TO ADDRESS</label>
						</div>
						<div class="col-4">
							<form:textarea path="billToAddress" id="billToAddress"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="billToAddressError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="shipToAddress">SHIP TO ADDRESS</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipToAddress" id="shipToAddress"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="shipToAddressError"></span>
						</div>
					</div>
					<input type="submit" value="CreateShipping" class="btn btn-success" />

				</form:form>
			</div>
			<c:if test="${!empty message}">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
		</div>

	</div>
</body>
</html>
