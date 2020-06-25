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
				<H1>WELCOME TO PURCHASE ORDER EDIT PAGE</H1>
			</div>
			<div class="card-body">
				<form:form action="update" method="post"
					modelAttribute="purchaseOrderType">
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="id">ID</label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" />
						</div>
						<div class="col-4">
							<!--error message  -->
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" id="orderCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="orderCodeError"> </span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="referenceNumber">REFERENCE NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="referenceNumber" id="referenceNumber"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="referenceNumberError"> </span>
						</div>
					</div>

					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="qualityCheck">REFERENCE NUMBER</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qualityCheck" id="qualityCheck"
								value="Required" class="form-control" />
							Required
							<form:radiobutton path="qualityCheck" id="qualityCheck"
								value="NotRequired" class="form-control" />
							NotRequired
						</div>
						<div class="col-4">
							<span id="qualityCheckError"> </span>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>