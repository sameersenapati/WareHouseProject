<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO ORDER METHOD REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="myForm" method="post" id="save"
					modelAttribute="orderMethod">
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="orderMode">ORDER MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" id="orderMode" value="Sale" />
							SALE
							<form:radiobutton path="orderMode" id="orderMode"
								value="Purchase" />
							PURCHASE
						</div>
						<div class="col-4">
							<span id="orderModeError"></span>
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
							<span id="orderCodeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="orderType">ORDER TYPE</label>
						</div>
						<div class="col-4">
							<form:select path="orderType" id="orderType" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="orderTypeError"></span>
						</div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="orderAcpt">ORDER ACCEPT</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAcpt" id="orderAcpt"
								value="Multi-Model" />
							Multi Model
							<form:checkbox path="orderAcpt" id="orderAcpt"
								value="AcceptReturn" />
							AcceptReturn

						</div>
						<div class="col-4">
							<span id="orderAcptError"></span>
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
					
					<input type="submit" value="Create" id="register"
						class="btn btn-success" />
				</form:form>

			</div>
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
	<H1>WELCOME TO ORDER METHOD REGISTER PAGE</H1>
	<form:form action="save" method="post" modelAttribute="orderMethod">
		<pre>
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
	Order Accept:
	<form:checkbox path="orderAcpt" value="Multi-Model" />Multi Model
	<form:checkbox path="orderAcpt" value="AcceptReturn" />AcceptReturn

	Description:
	<form:textarea path="description" />
		<input type="submit" value="Create" />
		</pre>
	</form:form>
	${message}
</body>
</html> --%>