<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h2>WELCOME TO GRN REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="grn">

					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="grnCode">GRN CODE</label>
						</div>
						<div class="col-4">
							<form:input path="grnCode" id="grnCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="grnCodeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="grnType">GRN TYPE</label>
						</div>
						<div class="col-4">
							<form:input path="grnType" id="grnType" class="form-control" />
						</div>
						<div class="col-4">
							<span id="grnTypeError"></span>
						</div>
					</div>
					
					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="po"> PURCHASE ORDER</label>
						</div>
						<div class="col-4">
							<form:select path="po.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${poMap}"/>
							</form:select>
						</div>
						<div class="col-4" id="poError"></div>
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
					<input type="submit" value="Create GRN" class="btn btn-success" />
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