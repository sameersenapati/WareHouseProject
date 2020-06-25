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
				<H3>WELCOME TO SHIPMENTTYPE EDIT PAGE</H3>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST"
					modelAttribute="shipmentType">

					<div class="row">
						 <div class="col-4" >
							<label for="shipId" >SHIPMENT ID</label>
							<div class="col-4">
								<form:input path="shipId" readonly="true"/>
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
							

							<%--  <form:input path="shipId" readonly="true" /> --%>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="shipMode">SHIPMENT MODE</label>
						</div>
						<div class="col-4">
							<form:select path="shipMode" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="Air">Air</form:option>
								<form:option value="Truck">Truck</form:option>
								<form:option value="Ship">Ship</form:option>
								<form:option value="Train">Train</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>



					<%-- ShipmentMode:
<form:select path="shipMode">

<form:option value="">--select--</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>
 --%>

					<div class="row">
						<div class="col-4" >
							<label for="shipCode">SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shipCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<%--  
 ShipmentCode:
<form:input path="shipCode" /> --%>


					<div class="row">
						<div class="col-4">
							<label for="enbShip">ENABLE SHIPMENT</label>
						</div>
						<div class="col-4">
							<form:select path="enbShip" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>

					<%-- EnableShipment:
<form:select path="enbShip">
<form:option value="">--select--</form:option>
<form:option value="YES">Yes</form:option>
<form:option value="NO">No</form:option>
</form:select>
 --%>

					<div class="row">
						<div class="col-4">
							<label for="shipGrade">SHIPMENT GRADE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrade" value="A" />
							A
							<form:radiobutton path="shipGrade" value="B" />
							B
							<form:radiobutton path="shipGrade" value="C" />
							C

						</div>
						<div class="col-4"></div>
					</div>

					<%-- ShipmentGrade:
<form:radiobutton path="shipGrade" value="A" />A
<form:radiobutton path="shipGrade" value="B" />B
<form:radiobutton path="shipGrade" value="C" />C
 --%>

					<div class="row">
						<div class="col-4">
							<label for="shipDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipDesc" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<%--  Description:
<form:textarea path="shipDesc" />
 --%>
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

