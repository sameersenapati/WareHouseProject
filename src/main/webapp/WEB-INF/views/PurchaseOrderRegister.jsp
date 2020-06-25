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
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>WELCOME TO PURCHASE ORDER REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="post"
					modelAttribute="purchaseOrderType">

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
							<label for="referenceNumber">REFERENCE NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="referenceNumber" id="referenceNumber"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="referenceNumberError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="qualityCheck">QUALITY CHECK</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qualityCheck" id="qualityCheck1"
								value="Required" />
							Required
							<form:radiobutton path="qualityCheck" id="qualityCheck2"
								value="NotRequired" />
							NotRequired
						</div>
						<div class="col-4">
							<span id="qualityCheckError"></span>
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
							<!-- error message -->
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
					
					<input type="submit" value="PlaceOrder" class="btn btn-success" />

				</form:form>
			</div>
			<c:if test="${!empty message}">
				<div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
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
	<H1>WELCOME TO PURCHASE ORDER REGISTER PAGE</H1>
	<form:form action="save" method="post"
		modelAttribute="purchaseOrderType">
		<pre>
OrderCode:
<form:input path="orderCode"/>

Reference Number:
<form:input path="referenceNumber"/>
Quality Check:
<form:radiobutton path="qualityCheck" value="Required" />REQUIRED
<form:radiobutton path="qualityCheck" value="NotRequired" />NOT REQUIRED
Default Status:
<form:input path="status"  readonly="true"/>
Description:
<form:textarea path="description"/>
<input type="submit" value="PlaceOrder"/>
</pre>
	</form:form>
	${message}
</body>
</html> --%>