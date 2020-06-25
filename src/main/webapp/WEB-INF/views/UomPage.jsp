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
				class="card-header bg-primary text-center text-yellow text-uppercase">
				<h1>WELCOME TO UOM PAGE</h1>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="save" method="post"
					modelAttribute="uomType">

					<!--new Row -->
					<div class="row">
						<div class="col-4">
							<label for="uomType">UOM TYPE</label>
						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING"> NO PACKING</form:option>
								<form:option value="-NA-">-NA-</form:option>
							</form:select>
						</div>
						<!-- Error Message -->
						<div class="col-4" id="uomTypeError"></div>
					</div>
					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="uomModel">UOM MODEL</label>
						</div>
						<div class="col-4">
							<form:input path="uomModel" class="form-control" />
						</div>
						<!-- Error Message -->
						<div class="col-2" id="uomModelError"></div>
						<div class="col-2">
							<form:errors path="uomModel" cssClass="text-danger" />
						</div>
					</div>


					<!-- new row -->
					<div class="row">
						<div class="col-4">
							<label for="udesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="udesc" class="form-control" />

						</div>
						<div class="col-4" id="udescError"></div>
					</div>

					<input type="submit" value="Register" id="register"
						class="btn btn-success" />
					<input type="reset" value="Clear" class="btn btn-danger" />

				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<b>${message}</b>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		//1. Hide Error section
		$("#uomModelError").hide();
		$("#udescError").hide();
		$("#uomTypeError").hide();

		//2. Define flag for error section
		var uomModelError = false;
		var udescError = false;
		var uomTypeError = false;

		//3. Link with action/event
		$("#uomModel").keyup(function() {
			validate_uomModel();
		});
		$("#uomModel").blur(function(){
			validate_uomModel_ajax();
		});
		$("#udesc").keyup(function() {
			validate_udesc();
		});

		$("#uomType").change(function() {
			validate_uomType();
		});

		//4. drfine one validation function
		function validate_uomModel() {
			var val = $("#uomModel").val();
			if (val == '') {
				$("#uomModelError").show();
				$("#uomModelError").html("Enter <b>UOM MODEL</b>")
				$("#uomModelError").css("color", "red");
				uomModelError = false;
			} else {
				$("#uomModelError").hide();
				uomModelError = true;
			}
			return uomModelError;
		}

		function validate_udesc() {
			var val = $("#udesc").val();
			if (val == '') {
				$("#udescError").show();
				$("#udescError").html("Enter <b>UOM DESCRIPTION</b>");
				$("#udescError").css("color", "red");
				udescError = false;
			} else {
				$("#udescError").hide();
				udescError = true;
			}

			return udescError;
		}

		function validate_uomType() {
			var val = $("#uomType").val();

			if (val == '') {
				$("#uomTypeError").show();
				$("#uomTypeError").html("Choose <b>UOM TYPE</b>");
				$("#uomTypeError").css("color", "red");
				uomTypeError = false;
			} else {
				$("#uomTypeError").hide();
				uomTypeError = true;
			}
			return uomTypeError;
		}

		// on click submit button
		$("#register").click(function() {
			//on click submit button

			//a. reset flags to false
			uomModelError = false;
			udescError = false;
			uomTypeError = false;

			//b. call all validate function
			validate_uomModel();
			validate_udescError();
			validate_uomType();

			//c. check if all are true then submit else dont
			if (uomModelError && udescError && uomTypeError) {
				return true;
			} else
				return false;
		});

		function validate_uomModel_ajax(){
             var val=$("#uomModel").val();

             $.ajax({
                url : 'modelExist',
                data : { "model": $("#uomModel").val()},
                success:function(resText){
                	if(resTxt!=''){
                     	 $("#uomModelError").show();
                	         $("#uomModelError").html(resTxt);
                	         $("#uomModelError").css("color","red");
                	        // $("#uomModel").val("");
                	         $("#uomModel").focus();//place cursor back
                     }else{
                     	$("#uomModelError").hide();
                     	$("#uomModelError").html("");
                     }
                    }  
                 });
			}
	});
</script>
</html>


<!-- UomType:
	<select name="uomType">
		<option>--select--</option>
		<option>PACKING</option>
		<option>NOPACKING</option>
	</select> -->
<%-- <c:if test="${!empty message }">
					<div class="card-footer bg-info text-red text-center">
						<b>${message}</b>
					</div>
				</c:if> --%>
<%-- ${message} --%>

<!-- Description:
	<textarea name="udesc"></textarea>
	<input type="submit" value="CREATE UOM"> 
 -->
<!-- 	 UomModel:
	<input type="text" name="uomModel" /> 
 -->