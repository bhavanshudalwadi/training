<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page import="java.text.SimpleDateFormat" %>
	<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="./parts/tscript.jsp" />
	
    <title>Offer List | Food Order</title>
    <style>
    	.table-responsive > div {
    		justify-content: space-between;
    	}
    </style>
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
		                  <h1>Offer List</h1>
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
                                <div class="bootstrap-data-table-panel shm">
                                    <div class="table-responsive">
                                        <table id="bootstrap-data-table-export" class="table table-striped table-bordered table_export_wrapper">
                                            <thead>
                                                <tr>
                                                    <th>Category Name</th>
                                                    <th>SubCategory Name</th>
                                                    <th>Offers Name</th>
                                                    <th>Offers Description</th>
                                                    <th>Start Date</th>
                                                    <th>End Date</th>
                                                    <th>Discount</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${offers}" var="offer">
                                                <tr>
                                                    <td>${offer.category.name}</td>
                                                    <td>${offer.subCategory.name}</td>
                                                    <td>${offer.name}</td>
                                                    <td>${offer.description}</td>
                                                    <td>${offer.startDate}</td>
                                                    <td>${offer.endDate}</td>
                                                    <td>${offer.discount}</td>
                                                    <td>
                                                    	<a class="btn btn-primary m-l-5" href="/offer/edit/${offer.id}"><span class="ti-pencil"></span></a>
                                                    	<a class="btn btn-primary m-l-5" href="/offer/delete/${offer.id}"><span class="ti-trash"></span></a>
                                                    </td>
                                                </tr>
                                             </c:forEach>
                                            </tbody>
                                        </table>
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
</body>
</html>