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
				<h3>WELCOME TO PART TYPE REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="partType">

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
							<label for="">UOM</label>
						</div>

						<div class="col-4">
							<form:select path="uomOb.uomId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${uomMap}" itemValue="uomId"
									itemLabel="uomModel" />
							</form:select>
							<form:select path="omPurchaseOb.partId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${omPurchaseMap}"  />
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">ORDER METHOD</label>
						</div>
						<div class="col-4">
							<form:select path="omOb.orderId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${omSaleMap}" />
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
						<div class="col-4"></div>
					</div>


					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />

						</div>
					</div>

				</form:form>

				<c:if test="${!empty message }">
					<div class="card-footer bg-info text-white text-center">
						<b>${message}</b>
					</div>
				</c:if>

			</div>
		</div>
	</div>
</body>
</html>
<%-- <H1>WELCOME TO PART TYPE REGISTER PAGE</H1>
	<form:form action="save" method="post" modelAttribute="partType">
		<pre>
	CODE:
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
	DESCRIPTION:
	<form:textarea path="partDesc" />
	<input type="submit" value="Create" />
	
	UOM:
        <form:select path="uomOb.uomId">
        	<form:option value="">-SELECT--</form:option>
        	<form:options items="${uomList}" itemValue="uomId"
					itemLabel="uomModel" />
        
        </form:select>	
	</pre>
	</form:form>
	${message}
</body>
</html>
 --%>