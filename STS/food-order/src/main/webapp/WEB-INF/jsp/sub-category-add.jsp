<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="./parts/tscript.jsp" />
	
    <title>Dashboard | Food Order</title>
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
		            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 p-r-0 title-margin-right">
		              <div class="page-header">
		                <div class="page-title">
		                  <h1>${subCategory != null?'Edit Sub Category':'Add Sub Category'}</h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">Manage Sub Category</li>
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
                                        <form action="/sub-category/${subCategory != null?'updateHandler':'addHandler'}" method="post">
                                        	<c:if test="${subCategory != null}">
                                        		<input type="hidden" name="id" value="${subCategory.id}" />
                                        	</c:if>
                                        	<div class="form-group">
                                            	<label for="category">Category</label>
                                                <select class="form-control" id="category" name="category" required>
													<option value="" selected>Select Category</option>
													<c:forEach items="${categories}" var="category">
														<c:choose>
														    <c:when test="${subCategory != null && subCategory.category.id == category.id}">
														        <option value="${category.id}" selected>${category.name}</option>
														    </c:when>
														    <c:otherwise>
														        <option value="${category.id}">${category.name}</option>
														    </c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="name">Name</label>
                                                <input type="text" class="form-control input-default" name="name" id="name" value="${subCategory != null?subCategory.name:''}" placeholder="Name" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" for="description">Description</label>
                                                <textarea class="form-control" rows="6" id="description" name="description" placeholder="Description">${subCategory != null?subCategory.description:''}</textarea>
                                            </div>
                                            <div class="form-group text-end">
                                            	<button type="submit" onclick="return checkValidation()" class="btn btn-primary m-b-10 m-l-5">${subCategory != null?'Update Sub Category':'Add Sub Category'}</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
	          		<div class="row">
	                    <div class="col-lg-12">
	                        <div class="footer">
	                            <p>2024 ©  Food Order</p>
	                        </div>
	                    </div>
	                </div>
	          	</section>
          	</div>
        </div>
    </div>
    
    <jsp:include page="./parts/bscript.jsp" />
    <script>
    	function checkValidation() {
    		let category = $("#category").val();
			let name = $("#name").val();
			
			if(category == '' || name == '') {
				toastr.error('Please Enter Valid Sub Category Details !!','Invalid Inputs',{
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