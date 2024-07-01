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
		                  <h1>${product != null?'Edit Product':'Add Product'}</h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">Manage Products</li>
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
                                        <form action="/product/${product != null?'updateHandler':'addHandler'}" method="post" enctype="multipart/form-data">
                                        	<input type="hidden" type="number" name="user" value="${user_id}" />
                                        	<c:if test="${product != null}">
                                        		<input type="hidden" name="id" value="${product.id}" />
                                        	</c:if>
                                       		<input type="hidden" name="image" value="${product != null?product.image:''}" />
                                        	<div class="form-group">
                                            	<label for="category">Category Name</label>
                                                <select class="form-control" id="category" name="category" required>
													<option selected>Select Category</option>
													<c:forEach items="${categories}" var="category">
														<c:choose>
														    <c:when test="${product != null && product.category.id == category.id}">
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
                                            	<label for="subCategory">SubCategory Name</label>
                                                <select class="form-control" id="subCategory" name="subCategory" required>
													<option selected>Select SubCategory</option>
<%-- 													<c:forEach items="${subcategories}" var="subcategory"> --%>
<%-- 														<c:choose> --%>
<%-- 														    <c:when test="${product != null && product.subCategory.id == subcategory.id}"> --%>
<%-- 														        <option value="${subcategory.id}" selected>${subcategory.name}</option> --%>
<%-- 														    </c:when> --%>
<%-- 														    <c:otherwise> --%>
<%-- 														        <option value="${subcategory.id}">${subcategory.name}</option> --%>
<%-- 														    </c:otherwise> --%>
<%-- 														</c:choose> --%>
<%-- 													</c:forEach> --%>
												</select>
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="name">Product Name</label>
                                                <input type="text" class="form-control input-default" name="name" id="name" value="${product != null?product.name:''}" required>
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="price">Product Price</label>
                                                <input type="number" class="form-control input-default" name="price" id="price" value="${product != null?product.price:''}" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" for="description">Product Description</label>
                                                <textarea class="form-control" rows="6" id="description" name="description">${product != null?product.description:''}</textarea>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" for="img">Product Image</label>
                                                <input type="file" class="form-control input-default" id="img" name="img" />
                                            </div>
                                            <div class="form-group text-end">
                                            	<button type="submit" onclick="return checkValidation()" class="btn btn-primary m-b-10 m-l-5">${product != null?'Update Product':'Add Product'}</button>
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$("#category").on('change', function() {
			let category = $(this).val();
			$("#subCategory").html("<option selected>Select SubCategory</option>");
			$.ajax({
				url : "http://localhost:8181/api/getSubCategoryList/"+category,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(subcategory => {
						$("#subCategory").append("<option value='"+subcategory.id+"'>"+subcategory.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
	</script>
	<c:if test="${product != null}">
		<script>
			let subCategoryId = "${product.subCategory.id}";
			$.ajax({
				url : "http://localhost:8181/api/getSubCategoryList/${product.category.id}",
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(subcategory => {
						if(subcategory.id == subCategoryId) {						
							$("#subCategory").append("<option value='"+subcategory.id+"' selected>"+subcategory.name+"</option>");
						}else {
							$("#subCategory").append("<option value='"+subcategory.id+"'>"+subcategory.name+"</option>");
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
	
	<script>
    	function checkValidation() {
    		let category = $("#category").val();
			let subCategory = $("#subCategory").val();
			let name = $("#name").val();
			let price = $("#price").val();
			let image = $('#img').prop('files');
			
			if(category == '' || subCategory == '' || name == '' || price == '') {
				toastr.error('Please Enter Valid Product Details !!','Invalid Inputs',{
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
			}else if(parseInt(price) < 0) {
				toastr.error('Please Enter Valid Price !!','Invalid Inputs',{
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
			}else if(image.length <= 0) {
				toastr.error('Please Select Product Image !!','Invalid Inputs',{
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