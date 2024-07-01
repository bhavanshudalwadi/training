<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <title>Login | Food Order</title>

   <link rel="shortcut icon" type="image/png" href="assets/images/favicon.png" />

    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="bg-dark">

    <div class="unix-login">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="#"><span>Food Order</span></a>
                        </div>
                        <div class="login-form rounded">
                            <h4>Restaurant Registration</h4>
                            <form action="/restaurantRegistrationHandler" method="post">
                            	<div class="row">
                            		<div class="col-md-6">
	                            		<div class="form-group">
		                                    <label>Restaurant Name</label>
		                                    <input type="text" name="name" class="form-control">
		                                </div>
                            		</div>
                            		<div class="col-md-6">
	                            		<div class="form-group">
		                                    <label>Contact No</label>
		                                    <input type="tel" name="contect_no" class="form-control">
		                                </div>
                            		</div>
                            		<div class="col-md-6">
	                            		<div class="form-group">
		                                    <label>Email</label>
		                                    <input type="email" name="email" class="form-control">
		                                </div>
                            		</div>
                            		<div class="col-md-6">
	                            		<div class="form-group">
		                                    <label>Password</label>
		                                    <input type="password" name="password" class="form-control">
		                                </div>
                            		</div>
                            		<div class="col-md-12">
                            			<label>Address</label>
                            			<textarea class="form-control" rows="3" name="address"></textarea>
                            		</div>
                            		<div class="col-md-6">
                            			<div class="form-group">
                                           	<label for="city">City</label>
                                               	<select class="form-control" id="city" name="city">
												<option selected>Select City</option>
												<c:forEach items="${cities}" var="city">
											        <option value="${city.id}">${city.name}</option>
												</c:forEach>
											</select>
                                        </div>
                            		</div>
                            		<div class="col-md-6">
                            			<div class="form-group">
                                           	<label for="city">Area</label>
                                           	<select class="form-control" id="area" name="area">
												
<%-- 												<c:forEach items="${areas}" var="area"> --%>
<%-- 											        <option value="${area.id}">${area.name}</option> --%>
<%-- 												</c:forEach> --%>
											</select>
                                        </div>
                            		</div>
                            	</div>
                                <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">Register</button>
                                <div class="register-link m-t-15 text-center">
                                    <p>Already have account ? <a href="/login"> Login Now</a></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$("#city").on('change', function() {
			let city = $(this).val();
			$("#area").html("<option selected>Select Area</option>");
			$.ajax({
				url : "http://localhost:8181/api/getAreaList/"+city,
				type : "GET",
				contentType: "application/json",
				dataType : "json",
				success : function(response) {
					response.map(area => {
						$("#area").append("<option value='"+area.id+"'>"+area.name+"</option>");
					})
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					console.error(error);
				}
			});
		});
	</script>
</body>
</html>