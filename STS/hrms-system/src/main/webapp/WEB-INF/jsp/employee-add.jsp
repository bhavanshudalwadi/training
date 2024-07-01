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
            				<jsp:param name="emp_id" value="${employee != null?employee.id:''}"/>
            			</jsp:include>
            		</div>
            		<div class="col-9">
            		<div class="row">
		            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 p-r-0 title-margin-right">
		              <div class="page-header">
		                <div class="page-title">
		                  <h1>${employee != null?'Edit Employee':'Add Employee'}</h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">Manage Employee</li>
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
                                        <form action="/emp/${employee != null?'updateHandler':'addHandler'}" method="post">
                                        	<c:if test="${employee != null}">
                                        		<input type="hidden" name="id" value="${employee.id}" />
                                        	</c:if>
                                        	<div class="row">
                                        		<div class="col-md-4">
                                        			<label>Employee Code</label>
                                        			<div class="d-flex">
	                                        			<input type="text" class="form-control input-default mr-3 w-25" name="codePrefix" id="codePrefix" value="${codePrefix}" required>
	                                        			<input type="text" class="form-control input-default w-75" name="codeValue" id="codeValue" value="${codeValue}" required>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-4">
                                       				<label>Pan Number</label>
                                       				<input type="text" class="form-control input-default" name="PAN" id="PAN" value="${employee != null?employee.PAN:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Old Employee Code</label>
                                       				<input type="text" class="form-control input-default" name="oldCode" id="oldCode" value="${employee != null?employee.oldCode:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Date Of Appointment</label>
                                       				<input type="date" class="form-control input-default" name="appointmentDate" id="appointmentDate" value="${employee != null?employee.appointmentDate:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Bio Matric Id</label>
                                       				<input type="text" class="form-control input-default" name="bioMatricId" id="bioMatricId" value="${employee != null?employee.bioMatricId:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Salutation</label>
                                       				<select class="form-control input-default" id="salutation" name="salutation" required>
														<option value="" selected>Select Salutation</option>
												        <option value="0">Dr.</option>
												        <option value="1">Kum.</option>
												        <option value="2">Shri</option>
												        <option value="3">Smt.</option>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="dept">Department</label>
	                                                <select class="form-control input-default" id="dept" name="dept" required>
														<option value="" selected>Select Department</option>
														<c:forEach items="${departments}" var="department">
															<c:choose>
															    <c:when test="${employee != null && employee.department.id == department.id}">
															        <option value="${department.id}" selected>${department.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${department.id}">${department.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>First Name</label>
                                       				<input type="text" class="form-control input-default" name="fname" id="fname" value="${employee != null?employee.fname:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Middle Name</label>
                                       				<input type="text" class="form-control input-default" name="mname" id="mname" value="${employee != null?employee.mname:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Last Name</label>
                                       				<input type="text" class="form-control input-default" name="lname" id="lname" value="${employee != null?employee.lname:''}" required>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="unit">Unit</label>
	                                                <select class="form-control input-default" id="unit" name="unit" required>
														<option value="" selected>Select Unit</option>
														<c:forEach items="${units}" var="unit">
															<c:choose>
															    <c:when test="${employee != null && employee.unit.id == unit.id}">
															        <option value="${unit.id}" selected>${unit.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${unit.id}">${unit.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="designation">Designation</label>
	                                                <select class="form-control input-default" id="designation" name="designation" required>
														<option value="" selected>Select Designation</option>
														<c:forEach items="${designations}" var="designation">
															<c:choose>
															    <c:when test="${employee != null && employee.designation.id == designation.id}">
															        <option value="${designation.id}" selected>${designation.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${designation.id}">${designation.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
	                                            	<label for="group">Group</label>
	                                                <select class="form-control input-default" id="group" name="group" required>
														<option value="" selected>Select Group</option>
														<c:forEach items="${groups}" var="group">
															<c:choose>
															    <c:when test="${employee != null && employee.group.id == group.id}">
															        <option value="${group.id}" selected>${group.name}</option>
															    </c:when>
															    <c:otherwise>
															        <option value="${group.id}">${group.name}</option>
															    </c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<div class="form-group mt-4">
	                                        			<label>Is Gazetted</label>
	                                       				<input type="checkbox" class="" name="isGazetted" id="isGazetted" value="true" ${employee != null?(employee.isGazetted?'checked':''):''}>
                                        			</div>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<label>Employee Eligible For</label>
                                       				<select class="form-control input-default" id="eligibleFor" name="eligibleFor" required>
														<option value="" selected>Select Eligible For</option>
												        <option value="0">EPF</option>
												        <option value="1">NPS</option>
												        <option value="2">GPF</option>
												        <option value="3">Other</option>
													</select>
                                        		</div>
                                        		<div class="col-md-4">
                                        			<div class="form-group mt-4">
	                                        			<label>Is Employee Cover Under Gratuity Act</label>
	                                       				<input type="checkbox" class="" name="isCoverGratuity" id="isCoverGratuity" value="true" ${employee != null?(employee.isCoverGratuity?'checked':''):''}>
                                        			</div>
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
				toastr.error('Please Enter Valid employee Details !!','Invalid Inputs',{
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
    </script>
</body>
</html>