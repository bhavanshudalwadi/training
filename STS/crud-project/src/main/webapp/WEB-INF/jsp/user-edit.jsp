<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Boot Hello World Practical</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">	
	</head>
	<body>
		<nav class="navbar bg-dark border-bottom border-body">
  <div class="container">
    <span class="navbar-brand mb-0 h1 text-white">CRUD App With Spring Security</span>
    <form class="d-flex" role="search">
      <a href="/logout" class="btn btn-success">Logout</a>
    </form>
  </div>
</nav>
		<div class="container mt-5 text-center">
			<h2>Edit User Details</h2>
			<c:if test="${msg != null}">
    		 	<div class="alert alert-success" role="alert">
				  	<c:out value="${msg}"/>
				</div>
	    	</c:if>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="/user/updateHandler" method="post">
						<input type="hidden" name="id" value="${ user.id }" >
						<input type="hidden" name="password" value="${ user.password }">
						<input class="form-control mt-2" type="text" name="name" placeholder="Enter your name" value="${ user.name }">
						<input class="form-control mt-2" type="text" name="email" placeholder="Enter your email" value="${ user.email }">
						<input class="form-control mt-2" type="text" name="phone" placeholder="Enter your phone" value="${ user.phone }">
						<input class="form-control mt-2" type="text" name="roles" placeholder="Enter your roles" value="${ user.roles }">
						<input class="form-control mt-2" type="text" name="education" placeholder="Enter your qualification" value="${ user.education }">
						<input class="form-control mt-2" type="text" name="company" placeholder="Enter your company name" value="${ user.company }">
						<input class="form-control mt-2" type="text" name="bio" placeholder="Enter your bio" value="${ user.bio }">
						<select class="form-select mt-2" name="country" id="country">
						  <option selected>Select Country</option>
						</select>
						<select class="form-select mt-2" name="state" id="state">
						  <option selected>Select State</option>
						</select>
						<select class="form-select mt-2" name="city" id="city">
						  <option selected>Select City</option>
						</select>
						<input class="btn btn-primary mt-3" type="submit" value="Update User Info">
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
			$(document).ready(function(){
                $.ajax({
                    url: "http://localhost:8181/countries.json",
                    type: "GET",
                    dataType: "json",
                    success: function(response) {
                    	$("#country").html("<option selected>Select Country</option>");
                    	$.each(response, function(index, country) {
                    		$("#country").append("<option value='"+country.id+"'>"+country.name+"</option>");
                    	})
                    	$("#country").val(${user.country});
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
                
               	let country = ${user.country!=null?user.country:-1};
               	$.ajax({
                    url: "http://localhost:8181/states.json",
                    type: "GET",
                    dataType: "json",
                    success: function(response) {
                    	$("#state").html("<option selected>Select State</option>");
                    	let ImpStstes = response.filter(state => state.country_id == country);
                    	$.each(ImpStstes, function(index, state) {
                    		$("#state").append("<option value='"+state.id+"'>"+state.name+"</option>");
                    	})
                    	$("#state").val(${user.state});
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
                
               	let state = ${user.state!=null?user.state:-1};
               	$.ajax({
                    url: "http://localhost:8181/cities.json",
                    type: "GET",
                    dataType: "json",
                    success: function(response) {
                    	$("#city").html("<option selected>Select City</option>");
                    	let ImpStstes = response.filter(city => city.state_id == state);
                    	$.each(ImpStstes, function(index, city) {
                    		$("#city").append("<option value='"+city.id+"'>"+city.name+"</option>");
                    	})
                    	$("#city").val(${user.city});
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
               	
               	$("#country").on('change', function(){
                	let country = $('#country').val();
                	$.ajax({
                        url: "http://localhost:8181/states.json",
                        type: "GET",
                        dataType: "json",
                        success: function(response) {
                        	$("#state").html("<option selected>Select State</option>");
                        	let ImpStstes = response.filter(state => state.country_id == country);
                        	$.each(ImpStstes, function(index, state) {
                        		$("#state").append("<option value='"+state.id+"'>"+state.name+"</option>");
                        	})
                        },
                        error: function(xhr, status, error) {
                            console.error(xhr.responseText);
                        }
                    });
                });
                
                $("#state").on('change', function(){
                	let state = $('#state').val();
                	$.ajax({
                        url: "http://localhost:8181/cities.json",
                        type: "GET",
                        dataType: "json",
                        success: function(response) {
                        	$("#city").html("<option selected>Select City</option>");
                        	let ImpStstes = response.filter(city => city.state_id == state);
                        	$.each(ImpStstes, function(index, city) {
                        		$("#city").append("<option value='"+city.id+"'>"+city.name+"</option>");
                        	})
                        },
                        error: function(xhr, status, error) {
                            console.error(xhr.responseText);
                        }
                    });
                });
	        });
		</script>
	</body>
</html>