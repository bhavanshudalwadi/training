<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="./parts/tscript.jsp" />

	<title>Dashboard | HRMS</title>
<!-- 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> -->
</head>

<body>
	<jsp:include page="./parts/sidebar.jsp">
		<jsp:param name="userRole" value="${userRole}" />
	</jsp:include>
	<jsp:include page="./parts/header.jsp" />

	<div class="content-wrap">
		<div class="main">
			<div class="container-fluid">
				<div class="row">
					<div class="col-3">
						<jsp:include page="./parts/employee-sidebar.jsp">
							<jsp:param name="emp" value="${emp != null?emp:''}" />
						</jsp:include>
					</div>
					<div class="col-9">
						<div class="row">
							<div
								class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 p-r-0 title-margin-right">
								<div class="page-header">
									<div class="page-title">
										<h1>${contact != null?'Edit Contact Details':'Add Contact Details'}</h1>
									</div>
								</div>
							</div>
							<div
								class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
								<div class="page-header page_header_2">
									<div class="page-title">
										<ol class="breadcrumb">
											<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
											<li class="breadcrumb-item active">Manage Contact
												Details</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
						<section id="main-content">
							<div class="row">
								<div class="col-lg-12">
									<div class="card">
										<div class="card-body">
											<div class="basic-form">
												<form
													action="/emp/${contact != null?'updateContactDetailsHandler':'addContactDetailsHandler'}"
													method="post">
													<c:if test="${contact != null}">
														<input type="hidden" name="id" value="${contact.id}" />
													</c:if>
													<input type="hidden" id="emp" name="emp"
														value="${emp != null?emp.id:''}" />
													<div class="row">
														<div class="col-md-4">
															<div class="row">
																<div class="col-md-9 px-2 pt-0">
																	<label>Work Phone</label> <input type="tel"
																		class="form-control input-default" name="workPhone"
																		id="workPhone"
																		value="${contact != null?contact.workPhone:''}">
																</div>
																<div class="col-md-3 px-2 pt-0">
																	<label>Extension</label> <input type="text"
																		class="form-control input-default" name="ext" id="ext"
																		value="${contact != null?contact.ext:''}">
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<label>Work Mobile</label> <input type="tel"
																class="form-control input-default" name="workMobile"
																id="workMobile"
																value="${contact != null?contact.workMobile:''}">
														</div>
														<div class="col-md-4">
															<label>Home Phone</label> <input type="tel"
																class="form-control input-default" name="homePhone"
																id="homePhone"
																value="${contact != null?contact.homePhone:''}">
														</div>
														<div class="col-md-4">
															<label>Home Mobile</label> <input type="tel"
																class="form-control input-default" name="homeMobile"
																id="homeMobile"
																value="${contact != null?contact.homeMobile:''}">
														</div>
														<div class="col-md-4">
															<label>Corporate Email</label> <input type="email"
																class="form-control input-default" name="coporateEmail"
																id="coporateEmail"
																value="${contact != null?contact.coporateEmail:''}">
														</div>
														<div class="col-md-4">
															<label>Personal Email</label> <input type="email"
																class="form-control input-default" name="personalEmail"
																id="personalEmail"
																value="${contact != null?contact.personalEmail:''}">
														</div>
														<div class="col-md-4">
															<label>Secondary Email</label> <input type="email"
																class="form-control input-default" name="secondaryEmail"
																id="secondaryEmail"
																value="${contact != null?contact.secondaryEmail:''}">
														</div>
													</div>
													<div class="d-flex justify-content-end">
														<input class="btn btn-secondary mr-2" type="reset"
															value="Reset" /> <input class="btn btn-primary"
															type="submit" value="Save & Continue" />
													</div>
												</form>
											</div>
										</div>
									</div>
									<hr />
									<div class="row" id="addresses">
										<c:forEach items="${addresses}" var="address">										
											<div class="col-md-6">
												<div class="card">
													<div class="card-body">
														<h5>${address.type == 0?'Parmanent':'Rental'} Address</h5>
														<hr />
														<p>${address.area}, ${address.city.name}, ${address.district.name}, ${address.state.name}, ${address.nation.name} - ${address.pincode}</p>
														<div class="d-flex justify-content-end">
															<button type="button" class="btn mr-2"><i class="ti-pencil"></i></button>
															<button type="button" class="btn" onclick="deleteAddress(${address.id})"><i class="ti-close"></i></button>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
										<div class="col-md-4" id="addAddressBtn">
											<button type="button" class="border-none bg-white" data-bs-toggle="modal" data-bs-target="#addressModal">
												<div class="card">
													<div class="card-body text-center my-5">
														<h5>Add New Address</h5>
														<i class="ti-plus"></i>
													</div>
												</div>
											</button>
										</div>
									</div>
								</div>
							</div>

						</section>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="footer">
							<p>2024 © HRMS</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="addressModal" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="addressModal" aria-hidden="true">
	  <div class="modal-dialog modal-lg modal-dialog-c entered rounded">
	    <div class="modal-content">
	      <div class="modal-header border-0">
	        <h5 class="modal-title">Add Address</h5>
	        <button type="button" class="btn" data-bs-dismiss="modal" aria-label="Close"><i class="ti-close"></i></button>
	      </div>
	      <div class="modal-body py-0">
	      	<form id="addressForm">
	      		<input type="hidden" id="emp" name="emp" value="${emp != null?emp.id:''}" />
		        <div class="row">
				    <div class="col-md-6">
				        <label for="type">Address Type</label>
				        <select class="form-control input-default" id="type" name="type">
				            <option value="" selected>Select Address Type</option>
				            <option value="0">Parmanent</option>
				        </select>
				    </div>
				    <div class="col-md-6">
				        <label for="area">Address</label>
				        <textarea class="form-control" rows="3" id="area" name="area"></textarea>
				    </div>
				    <div class="col-md-6">
				        <label for="nation">Country</label>
				        <select class="form-control input-default" id="nation" name="nation">
				            <option value="" selected>Select Country</option>
				            <c:forEach items="${countries}" var="country">	            	
					            <option value="${country.id}">${country.name}</option>
				            </c:forEach>
				        </select>
				    </div>
				    <div class="col-md-6">
				        <label for="state">State</label>
				        <select class="form-control input-default" id="state" name="state">
				            <option value="" selected>Select State</option>
				            <option value="0">Gujarat</option>
				        </select>
				    </div>
				    <div class="col-md-6">
				        <label for="district">District</label>
				        <select class="form-control input-default" id="district" name="district">
				            <option value="" selected>Select District</option>
				            <option value="0">Bhavnagar</option>
				        </select>
				    </div>
				    <div class="col-md-6">
				        <label for="city">City</label>
				        <select class="form-control input-default" id="city" name="city">
				            <option value="" selected>Select City</option>
				            <option value="0">Bhavnagar</option>
				        </select>
				    </div>
				    <div class="col-md-6">
				        <label for="pincode">Pincode</label>
				        <input type="number" class="form-control input-default" name="pincode" id="pincode" />
				    </div>
				    <div class="col-md-6">
	                    <div class="form-group mt-4">
	            			<label>All Addresses are same ?</label>
	           				<input type="checkbox" class="input-default" value="true" name="isAddressesSame" id="isAddressesSame" />
	           			</div>
				    </div>
				    <div class="col-md-6">
				        <label for="propertyType">Proparty Type</label> <br />
				        <input type="radio" class="input-default" name="propertyType" id="propertyTypeOwner" value="0" />
				        <label>Owner</label>
				        <input type="radio" class="input-default" name="propertyType" id="propertyTypeTenant" value="1" />
				        <label>Tenant</label>
				    </div>
				</div>
	      	</form>
	      </div>
	      <div class="modal-footer border-0 justify-content-start">
	        <button type="button" class="btn btn-primary" id="addAddress" style="width: 150px">Add</button>
	        <button type="button" class="btn btn-secondary" id="addressModelClose" data-bs-dismiss="modal" style="width: 150px">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

	<jsp:include page="./parts/bscript.jsp" />
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	<script>
// 		function checkValidation() {
// 			let name = $("#name").val();
// 			let description = $("#description").val();

// 			if (name == '') {
// 				toastr.error('Please Enter Valid contact Details !!',
// 						'Invalid Inputs', {
// 							"positionClass" : "toast-top-right",
// 							timeOut : 3000,
// 							"closeButton" : false,
// 							"debug" : false,
// 							"newestOnTop" : true,
// 							"progressBar" : true,
// 							"preventDuplicates" : true,
// 							"onclick" : null,
// 							"showDuration" : "300",
// 							"hideDuration" : "1000",
// 							"extendedTimeOut" : "1000",
// 							"showEasing" : "swing",
// 							"hideEasing" : "linear",
// 							"showMethod" : "fadeIn",
// 							"hideMethod" : "fadeOut",
// 							"tapToDismiss" : false
// 						});
// 				return false;
// 			}
// 		}
		$("#addAddress").on('click', function() {
			$.ajax({
				url : "http://localhost:8181/api/addAddress",
				type : "POST",
				dataType : "json",
				data: $('#addressForm').serialize(),
				success : function(response) {
					$("#addressModelClose").click();
					window.location.reload();
					
// 					var helper = document.createElement('div');
// 					helper.classList.add("col-md-6");
// 					helper.innerHTML = '<div class="col-md-6"><div class="card">' +
// 											'<div class="card-body">' +
// 												'<h5>'+response.type == 0?'Parmanent':'Rented'+' Address</h5><hr />' +
// 												'<p>'+response.area+', '+response.city.name+', '+response.district.name+', '+response.state.name+', '+response.nation.name+' - '+response.pincode+'</p>' +
// 												'<div class="d-flex justify-content-end">' +
// 													'<button type="button" class="btn mr-2"><i class="ti-pencil"></i></button>' +
// 													'<button type="button" class="btn"><i class="ti-close"></i></button>' +
// 												'</div>' +
// 											'</div>' +
// 										'</div></div>';
										
// 					const parentDiv = document.getElementById("addresses");
// 			        parentDiv.appendChild(helper);
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
	</script>
	
	<script>
		$("#nation").on('change', function() {
			let country = $(this).val();
			$("#state").html("<option selected>Select State</option>");
			$.ajax({
				url : "http://localhost:8181/api/getStates/"+country,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(state => {
						$("#state").append("<option value='"+state.id+"'>"+state.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
		
		$("#state").on('change', function() {
			let state = $(this).val();
			$("#district").html("<option selected>Select District</option>");
			$.ajax({
				url : "http://localhost:8181/api/getDistricts/"+state,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(district => {
						$("#district").append("<option value='"+district.id+"'>"+district.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
	
		$("#district").on('change', function() {
			let district = $(this).val();
			$("#city").html("<option selected>Select City</option>");
			$.ajax({
				url : "http://localhost:8181/api/getCities/"+district,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(city => {
						$("#city").append("<option value='"+city.id+"'>"+city.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
		
		function deleteAddress(id) {
			$.ajax({
				url : "http://localhost:8181/api/deleteAddress/"+id,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					alert(response);
					window.location.reload();
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
					window.location.reload();
					console.error(error);
				}
			});
		}
	</script>
</body>
</html>