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
			<div class="card-header bg-primary text-white text-uppercase">
				<h1>Welcome to Sale Order Register Page</h1>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="saleOrder">
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" id="orderCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="orderCodeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="refNumber">REFERENCE NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="refNumber" id="refNumber" class="form-control" />
						</div>
						<div class="col-4">
							<span id="refNumberError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="stockMode">STOCK MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" id="stockMode" value="Grade" />
							Grade
							<form:radiobutton path="stockMode" id="stockMode" value="Margin" />
							Margin
						</div>
						<div class="col-4">
							<span id="stockModeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="stockSource">STOCK SOURCE</label>
						</div>
						<div class="col-4">
							<form:select path="stockSource">
								<form:option value="">--SELECT--</form:option>
								<form:option value="OPEN">OPEN</form:option>
								<form:option value="AVAIL">AVAIL</form:option>
								<form:option value="REFUND">REFUND</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="stockSourceError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="status">DEFAULT STATUS</label>
						</div>
						<div class="col-4">
							<form:input path="status" id="status" readonly="true"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="statusError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="description">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:input path="description" id="description"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="descriptionError"></span>
						</div>
					</div>

					<input type="submit" value="CreateSaleOrder"
						class="btn btn-success" />

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











<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>WELCOME TO SALEORDER REGISTER PAGE</H3>
	<form:form action="save" method="post" modelAttribute="saleOrder">
		<pre>
OrderCode:
<form:input path="orderCode" />
Ref Number:
<form:input path="refNumber" />
Stock Mode:
<form:radiobutton path="stockMode" value="Grade" />GRADE
<form:radiobutton path="stockMode" value="Margin" />MARGIN
Stock Source:
<form:select path="stockSource">
<form:option value="">--SELECT--</form:option>
<form:option value="OPEN">OPEN</form:option>
<form:option value="AVAIL">AVAIL</form:option>
<form:option value="REFUND">REFUND</form:option>
</form:select>
Default Status:
<form:input path="status" readonly="true" />
Description:
<form:textarea path="description" />
<input type="submit" value="CreateSaleOrder" />
</pre>
	</form:form>
	${message}
</body>
</html> --%>