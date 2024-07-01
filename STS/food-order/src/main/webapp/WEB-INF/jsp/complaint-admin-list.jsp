<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="./parts/tscript.jsp" />
	
    <title>Complaint List | Food Order</title>
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
		                  <h1>Complaint List</h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">Manage Complaint</li>
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
                                                	<th>Username</th>
                                                    <th>Subject</th>
                                                    <th>Description</th>
                                                    <th>Complaint Date</th>
                                                    <th>Reply</th>
                                                    <th>Reply Date</th>
                                                    <th>Attachment</th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${complaints}" var="complaint">
                                                <tr>
                                                	<td>${complaint.user.email}</td>
                                                    <td>${complaint.subject}</td>
                                                    <td>${complaint.description}</td>
                                                    <td>${complaint.complaintDate}</td>
                                                    <c:if test="${complaint.reply == null}">
                                                    	<td><a class="btn btn-primary m-l-5" href="/complaint/resolve/${complaint.id}">Reply</a></td>
                                                    	<td></td>
                                                    </c:if>
                                                    <c:if test="${complaint.reply != null}">
                                                    	<td>${complaint.reply}</td>
                                                    	<td>${complaint.replyDate}</td>
                                                    </c:if>
                                                    <td><a class="btn btn-primary m-l-5" href="/upload/pdf/${complaint.attachment}"><span class="ti-pin-alt"></span></a></td>
                                                    <td>${complaint.status ? '<span class="badge badge-success">RESOLVED</span>' : '<span class="badge badge-warning">PANDING</span>'}</td>
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