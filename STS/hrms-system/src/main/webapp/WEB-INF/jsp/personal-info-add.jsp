<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="./parts/tscript.jsp" />
	
    <title>Dashboard | HRMS</title>
</head>

<body>
	<jsp:include page="./parts/sidebar.jsp">
		<jsp:param name="userRole" value="${userRole}"/>
	</jsp:include>
	<jsp:include page="./parts/header.jsp" />
	
	 <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
            	<div class="row">
            		<div class="col-3">
            			<jsp:include page="./parts/employee-sidebar.jsp">
            				<jsp:param name="emp" value="${emp != null?emp:''}"/>
            			</jsp:include>
            		</div>
            		<div class="col-9">
	                	<div class="row">
			            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 p-r-0 title-margin-right">
			              <div class="page-header">
			                <div class="page-title">
			                  <h1>${personalInfo != null?'Edit Personal Info':'Add Personal Info'}</h1>
			                </div>
			              </div>
			            </div>
			            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
			              <div class="page-header page_header_2">
			                <div class="page-title">
			                  <ol class="breadcrumb">
			                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			                    <li class="breadcrumb-item active">Manage Personal Info</li>
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
                                        <form action="/emp/${personalInfo != null?'updatePersonalInfoHandler':'addPersonalInfoHandler'}" method="post">
                                        	<c:if test="${personalInfo != null}">
                                        		<input type="hidden" name="id" value="${personalInfo.id}" />
                                        	</c:if>
                                        	<input type="hidden" id="emp" name="emp" value="${emp != null?emp.id:''}" />
                                        	<div class="row">
                                        		<div class="col-md-4">
                                        			<label>Gender</label>
                                       				<select class="form-control input-default" id="gender" name="gender">
														<option value="" selected>Select Gender</option>
												        <option value="0">Male</option>
												        <option value="1">Female</option>
													</select>
                                        		</div> 
                                        		<div class="col-md-4">
                                        			<label>Marriage Status</label>
                                       				<select class="form-control input-default" id="marriageStatus" name="marriageStatus">
														<option value="" selected>Select Marriage Status</option>
												        <option value="0">Divorcy</option>
												        <option value="1">Married</option>
												        <option value="2">Unmarried</option>
													</select>
                                        		</div> 
                                        		<div class="col-md-4">
                                        			<label>Date Of Birth</label>
                                       				<input type="date" class="form-control input-default" name="DOB" id="DOB" value="${personalInfo != null?personalInfo.DOB:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Date Of Marriage</label>
                                       				<input type="date" class="form-control input-default" name="DOM" id="DOM" value="${personalInfo != null?personalInfo.DOM:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                       				<label>Birth Place</label>
                                       				<input type="text" class="form-control input-default" name="birthPlace" id="birthPlace" value="${personalInfo != null?personalInfo.birthPlace:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Community Category</label>
                                       				<select class="form-control input-default" id="community" name="community" required>
														<option value="" selected>Select Community Category</option>
												        <option value="0">General</option>
												        <option value="1">SEBC</option>                                                                                     
												        <option value="2">ST</option>
												        <option value="3">SC</option>
													</select>
                                        		</div> 
                                        		<div class="col-md-4">
                                        			<label>UID No.</label>
                                       				<input type="text" class="form-control input-default" name="UID" id="UID" value="${personalInfo != null?personalInfo.UID:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>GPF A/C No.</label>
                                       				<input type="text" class="form-control input-default" name="GPFAccNo" id="GPFAccNo" value="${personalInfo != null?personalInfo.GPFAccNo:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Religion</label>
                                       				<select class="form-control input-default" id="religion" name="religion" required>
														<option value="" selected>Select Religion</option>
												        <option value="0">Buddhism</option>
												        <option value="1">Christianity</option>                                                                                     
												        <option value="2">Hinduism</option>
												        <option value="3">Sikkish</option>
												        <option value="4">Atheist</option>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Caste</label>
                                       				<select class="form-control input-default" id="caste" name="caste" required>
														<option value="" selected>Select Caste</option>
												        <option value="0">Agri</option>
												        <option value="1">Ahir</option>
												        <option value="2">Ayar Bericha</option>
												        <option value="3">Barot</option>
												        <option value="4">Vahivancha</option>
												        <option value="5">Charan</option>
												        <option value="6">Gadhvi</option>
												        <option value="7">Gadhavi</option>
												        <option value="8">Bavri or Baori</option>
												        <option value="9">Bawa</option>
												        <option value="10">Atit Bawa</option>
												        <option value="11">Goswami</option>
												        <option value="12">Gosai</option>
												        <option value="13">Bharwad</option>
												        <option value="14">Koli</option>
												        <option value="15">Goti</option>
												        <option value="16">Mochi</option>
												        <option value="17">Vanza (Darji)</option>
												        <option value="18">Bafan (Muslim)</option>
													</select>
                                        		</div>
                                        		<div class="col-md-8">
                                        			<label>Community Category Reference</label>
                                       				<input type="text" class="form-control input-default" name="communityCatRef" id="communityCatRef" value=${personalInfo != null?personalInfo.getComuunityCatRef():''}>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="nationality">Nationality</label>
	                                                <select class="form-control input-default" id="nationality" name="nationality" required>
														<option value="" selected>Select Nationality</option>
														<c:forEach items="${nations}" var="nation">
															<c:choose>
															    <c:when test="${personalInfo != null && personalInfo.nationality.id == nation.id}">
															        <option value="${nation.id}" selected>${nation.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${nation.id}">${nation.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Postal Life Insurance Policy No</label>
                                       				<input type="text" class="form-control input-default" name="PLInsPolicyNo" id="PLInsPolicyNo" value="${personalInfo != null?personalInfo.PLInsPolicyNo:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Hobbies</label>
                                       				<input type="text" class="form-control input-default" name="hobbies" id="hobbies" value="${personalInfo != null?personalInfo.hobbies:''}" required>
                                        		</div>
                                        		<div class="col-md-12"><hr style="height:0.0250in; border:none; color:#ccc; background-color:#ccc;"/></div>
                                        		<div class="col-md-4">
	                                            	<label for="bank">Bank Name</label>
	                                                <select class="form-control input-default" id="bank" name="bank" required>
														<option value="" selected>Select Bank</option>
														<c:forEach items="${banks}" var="bank">
															<c:choose>
															    <c:when test="${personalInfo != null && personalInfo.bank.id == bank.id}">
															        <option value="${bank.id}" selected>${bank.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${bank.id}">${bank.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="bankBranch">Bank Branch Name</label>
	                                                <select class="form-control input-default" id="bankBranch" name="bankBranch" required>
														<option value="" selected>Select Bank Branch</option>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Bank A/C Number</label>
                                       				<input type="number" class="form-control input-default" name="bankAccNO" id="bankAccNO" value="${personalInfo != null?personalInfo.bankAccNO:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>IFSC Code</label>
                                       				<input type="text" class="form-control input-default" name="IFSCCode" id="IFSCCode" value="${personalInfo != null?personalInfo.IFSCCode:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>BSR Code</label>
                                       				<input type="number" class="form-control input-default" min="1000000" max="9999999" name="BSRCode" id="BSRCode" value="${personalInfo != null?personalInfo.BSRCode:''}" required>
                                        		</div>
                                        		<div class="col-md-4"></div>
                                        		<div class="col-md-12"><hr style="height:0.0250in; border:none; color:#ccc; background-color:#ccc;"/></div>
                                        		<div class="col-md-4">
                                        			<label>Passport No</label>
                                       				<input type="text" class="form-control input-default" name="passportNo" id="passportNo" placeholder="Example - A6989089" value="${personalInfo != null?personalInfo.passportNo:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Date Of Expiry</label>
                                       				<input type="date" class="form-control input-default" name="passportExpDt" id="passportExpDt" value="${personalInfo != null?personalInfo.passportExpDt:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Visa Detail</label>
                                       				<input type="text" class="form-control input-default" name="visaDetails" id="visaDetails" value="${personalInfo != null?personalInfo.visaDetails:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Driving License Number</label>
                                       				<input type="text" class="form-control input-default" name="drivingLicNo" id="drivingLicNo" value="${personalInfo != null?personalInfo.drivingLicNo:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>License issue for (Vehicle Type)</label>
                                       				<select class="form-control input-default" id="drivingLicVehicleType" name="drivingLicVehicleType" required>
														<option value="" selected>Select Vehicle Type</option>
												        <option value="0">MC 50cc</option>
												        <option value="1">LMV-NT</option>
												        <option value="2">FVG</option>
												        <option value="3">MC EX50CC</option>
												        <option value="3">MCWG</option>
												        <option value="3">HGMV</option>
												        <option value="3">HPMV</option>
												        <option value="3">MGV</option>
												        <option value="3">HMV</option>
												        <option value="3">Trailer</option>
												        <option value="3">LMV</option>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Valid Upto</label>
                                       				<input type="date" class="form-control input-default" name="drivingLicValidUptoDt" id="drivingLicValidUptoDt" value="${personalInfo != null?personalInfo.drivingLicValidUptoDt:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Issued State/UT</label>
													<select class="form-control input-default" id="drivingLicIssuerState" name="drivingLicIssuerState">
														<option value="" selected>Select State</option>
														<c:forEach items="${states}" var="state">
															<c:choose>
															    <c:when test="${personalInfo != null && personalInfo.drivingLicIssuerState.id == state.id}">
															        <option value="${state.id}" selected>${state.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${state.id}">${state.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-2">
                                        			<div class="form-group mt-4">
	                                        			<label>Government Vehicle Provided ?</label>
	                                       				<input type="checkbox" class="" name="isOwnGovVehicle" id="isOwnGovVehicle" ${personalInfo != null?(personalInfo.isOwnGovVehicle?'checked':''):'false'}>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-2 d-none govVehicle">
                                        			<div class="form-group mt-4">
	                                        			<label>Government Vehicle Used For On Duty ?</label>
	                                       				<input type="checkbox" class="" name="isGovVehicleUsedForOnDuty" id="isGovVehicleUsedForOnDuty" ${personalInfo != null?(personalInfo.isGovVehicleUsedForOnDuty?'checked':''):'false'}>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-4 d-none govVehicle">
                                        			<label>Details Of Vehicle Provided</label>
                                       				<input type="text" class="form-control input-default" name="govVehicleDetails" id="govVehicleDetails" value="${personalInfo != null?personalInfo.govVehicleDetails:''}" required>
                                        		</div>
                                        		<div class="col-md-2">
                                        			<div class="form-group mt-4">
	                                        			<label>Is Resident of Other Country ?</label>
	                                       				<input type="checkbox" class="" name="isResidentOfOtherCountry" id="isResidentOfOtherCountry" ${personalInfo != null?(personalInfo.isResidentOfOtherCountry?'checked':''):'false'}>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-4 d-none resOfOtherCountry">
                                        			<label>Migration Date Of India</label>
                                       				<input type="date" class="form-control input-default" name="migDtOfIndia" id="migDtOfIndia" value="${personalInfo != null?personalInfo.migDtOfIndia:''}" required>
                                        		</div>
                                        		<div class="col-md-4 d-none resOfOtherCountry">
	                                            	<label for="residentOf">Country</label>
	                                                <select class="form-control input-default" id="residentOf" name="residentOf" required>
														<option value="" selected>Select Country</option>
														<c:forEach items="${nations}" var="nation">
															<c:choose>
															    <c:when test="${personalInfo != null && personalInfo.residentOf.id == nation.id}">
															        <option value="${nation.id}" selected>${nation.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${nation.id}">${nation.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4 d-none resOfOtherCountry">
                                        			<label>Other Country Address</label>
                                       				<textarea class="form-control" rows="6" id="otherCountryAddress" name="otherCountryAddress">${personalInfo != null?personalInfo.otherCountryAddress:''}</textarea>
                                        		</div>
                                        		<div class="col-md-2">
                                        			<div class="form-group mt-4">
	                                        			<label>Is Any Diciplinary Proceeding ?</label>
	                                       				<input type="checkbox" class="" name="isAnyDiciplinaryProceeding" id="isAnyDiciplinaryProceeding" ${personalInfo != null?(personalInfo.isAnyDiciplinaryProceeding?'checked':''):'false'}>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-6">
                                        			<label>Additional Information</label>
                                       				<textarea class="form-control" rows="6" id="additionalInfo" name="additionalInfo">${personalInfo != null?personalInfo.additionalInfo:''}</textarea>
                                        		</div>
                                        	</div>
                                        	<div class="d-flex justify-content-end">
                                        		<input class="btn btn-secondary mr-2" type="reset" value="Reset" />
                                        		<input class="btn btn-primary" type="submit" value="Save & Continue" />
                                        	</div>
                                        </form>
                                    </div>
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
	                            <p>2024 ©  HRMS</p>
	                        </div>
	                    </div>
	                </div>
          	</div>
        </div>
    		
    </div>
    
    <jsp:include page="./parts/bscript.jsp" />
    
    <script>
    	function checkValidation() {
    		let name = $("#name").val();
			let description = $("#description").val();
			
			if(name == '') {
				toastr.error('Please Enter Valid personalInfo Details !!','Invalid Inputs',{
			        "positionClass": "toast-top-right",
			        timeOut: 3000,
			        "closeButton": false,
			        "debug": false,
			        "newestOnTop": true,
			        "progressBar": true,
			        "preventDuplicates": true,
			        "onclick": null,
			        "showDuration": "300",
			        "hideDuration": "1000",
			        "extendedTimeOut": "1000",
			        "showEasing": "swing",
			        "hideEasing": "linear",
			        "showMethod": "fadeIn",
			        "hideMethod": "fadeOut",
			        "tapToDismiss": false
			    });
				return false;
			}
    	}	
    	$("#isOwnGovVehicle").on('change', function () {
    		if(this.checked) {
	    		$(".govVehicle").removeClass("d-none");
	    		$(".govVehicle").addClass("d-block");
    		}else {
    			$(".govVehicle").addClass("d-none");
	    		$(".govVehicle").removeClass("d-block");
    		}
   			$("#govVehicleDetails").val("");
   			$("#isGovVehicleUsedForOnDuty").prop("checked", false);
    	});
    	$("#isResidentOfOtherCountry").on('change', function () {
    		if(this.checked) {
	    		$(".resOfOtherCountry").removeClass("d-none");
	    		$(".resOfOtherCountry").addClass("d-block");
    		}else {
    			$(".resOfOtherCountry").addClass("d-none");
	    		$(".resOfOtherCountry").removeClass("d-block");
    		}
   			$("#migDtOfIndia").val("");
   			$("#residentOf").val("");
   			$("#otherCountryAddress").val("");
    	});
		$("#bank").on('change', function() {
			let bank = $(this).val();
			$("#bankBranch").html("<option selected>Select Bank Branch</option>");
			$.ajax({
				url : "http://localhost:8181/api/getBankBranches/"+bank,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(branch => {
						$("#bankBranch").append("<option value='"+branch.id+"'>"+branch.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
		
		$("#bankBranch").on('change', function() {
			let branch = $(this).val();
			if(branch != '') {
				$.ajax({
					url : "http://localhost:8181/api/getIFSCCode/"+branch,
					type : "GET",
					contentType: "application/json",
					dataType : "json",
					success : function(response) {
						$("#IFSCCode").val(response);
					},
					error : function(xhr, status, error) {
						$("#IFSCCode").val(xhr.responseText);
						console.error(xhr.responseText);
						console.error(error);
					}
				});
			}
		})
    </script>
    
    <c:if test="${personalInfo != null}">
	    <script>
	    	$("#marriageStatus").val(${personalInfo.marriageStatus});
	    	$("#gender").val(${personalInfo.gender});
	    	$("#drivingLicVehicleType").val(${personalInfo.drivingLicVehicleType});
	    	$("#caste").val(${personalInfo.caste});
	    	$("#religion").val(${personalInfo.religion});
	    	$("#community").val(${personalInfo.community});
	    	
	    	if(${personalInfo.isOwnGovVehicle}) {
	    		$(".govVehicle").removeClass("d-none");
	    		$(".govVehicle").addClass("d-block");
	    	}
	    	if(${personalInfo.isResidentOfOtherCountry}) {
	    		$(".resOfOtherCountry").removeClass("d-none");
	    		$(".resOfOtherCountry").addClass("d-block");
	    	}
	    	
	    	let bank = ${personalInfo.bank.id};
	    	let bankBranch = ${personalInfo.bankBranch.id};
			$("#bankBranch").html("<option>Select Bank Branch</option>");
			$.ajax({
				url : "http://localhost:8181/api/getBankBranches/"+bank,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(branch => {
						if(branch.id === bankBranch) {							
							$("#bankBranch").append("<option value='"+branch.id+"' selected>"+branch.name+"</option>");
						}else {
							$("#bankBranch").append("<option value='"+branch.id+"'>"+branch.name+"</option>");
						}
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
	    </script>
    </c:if>
</body>
</html>