<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		                  <h1>Welcome, <span>ADMIN_EMAIL</span></h1>
		                </div>
		              </div>
		            </div>
		            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 p-l-0 title-margin-left">
		              <div class="page-header page_header_2">
		                <div class="page-title">
		                  <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		                    <li class="breadcrumb-item active">home</li>
		                  </ol>
		                </div>
		              </div>
		            </div>            
          		</div>
          		<section id="main-content">
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