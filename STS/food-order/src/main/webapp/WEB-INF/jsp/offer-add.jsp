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
		                  <h1>${offer != null?'Edit Offer':'Add Offer'}</h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">Manage Offers</li>
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
                                        <form action="/offer/${offer != null?'updateHandler':'addHandler'}" method="post" enctype="multipart/form-data">
                                        	<input type="hidden" type="number" name="user" value="${user_id}" />
                                        	<c:if test="${offer != null}">
                                        		<input type="hidden" name="id" value="${offer.id}" />
                                        	</c:if>
                                        	<div class="form-group">
                                            	<label for="category">Category Name</label>
                                                <select class="form-control" id="category" name="category">
													<option selected>Select Category</option>
													<c:forEach items="${categories}" var="category">
														<c:choose>
														    <c:when test="${offer != null && offer.category.id == category.id}">
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
                                                <select class="form-control" id="subCategory" name="subCategory">
													<option selected>Select SubCategory</option>
<%-- 													<c:forEach items="${subcategories}" var="subcategory"> --%>
<%-- 														<c:choose> --%>
<%-- 														    <c:when test="${offer != null && offer.subCategory.id == subcategory.id}"> --%>
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
                                            	<label class="col-sm-4 control-label" for="name">Offer Name</label>
                                                <input type="text" class="form-control input-default" name="name" id="name" value="${offer != null?offer.name:''}">
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="discount">Discount(%)</label>
                                                <input type="number" class="form-control input-default" min="0" max="100" name="discount" id="discount" value="${offer != null?offer.discount:''}">
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" for="description">Offer Description</label>
                                                <textarea class="form-control" rows="6" id="description" name="description" placeholder="Description">${offer != null?offer.description:''}</textarea>
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="startDate">Start Date</label>
                                                <input type="date" class="form-control input-default" name="startDate" id="startDate" value="${offer != null?offer.startDate:''}">
                                            </div>
                                            <div class="form-group">
                                            	<label class="col-sm-4 control-label" for="endDate">End Date</label>
                                                <input type="date" class="form-control input-default" name="endDate" id="endDate" value="${offer != null?offer.endDate:''}">
                                            </div>
                                            <div class="form-group text-end">
                                            	<button type="submit" class="btn btn-primary m-b-10 m-l-5">${offer != null?'Update Offer':'Add Offer'}</button>
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
	<c:if test="${offer != null}">
		<script>
			let subCategoryId = "${offer.subCategory.id}";
			$.ajax({
				url : "http://localhost:8181/api/getSubCategoryList/${offer.category.id}",
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
</body>
</html>