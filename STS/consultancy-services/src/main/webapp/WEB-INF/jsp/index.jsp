<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Index Page</title>
</head>
<body>
	<nav class="navbar bg-dark border-bottom border-body" style="height: 80px">
  <div class="container" style="height: 80px">
    <span class="navbar-brand mb-0 h1 text-white">Consultancy Service</span>
    <form class="d-flex justify-content-between" style="width: 100px"
				role="search">
				<a href="/logout" class="btn btn-success p-2">Logout</a>
			</form>
  </div>
</nav>
	<c:if test="${msg}">
		<div class="alert alert-success d-none" role="alert">${msg}</div>
	</c:if>
	
	<div class="container mt-5">
		<c:if test="${isStudent}">
			<h2>Consultant List</h2>
			<table class="table table-striped table-hover">
			  <thead class="table-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Specification</th>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody id="result">
			  	
			  </tbody>
			</table>
			<h2>My Appointments</h2>
			<table class="table table-striped table-hover">
			  <thead class="table-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Consultant Id</th>
			      <th scope="col">Start Time</th>
			      <th scope="col">End Time</th>
			      <th scope="col">Description</th>
			      <th scope="col">Status</th>
			    </tr>
			  </thead>
			  <tbody id="result2">
			  	
			  </tbody>
			</table>
		</c:if>
	
		<c:if test="${isConsultant}">
			<h2>Appointment List</h2>
			<table class="table table-striped table-hover">
			  <thead class="table-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Student Id</th>
			      <th scope="col">Start Time</th>
			      <th scope="col">End Time</th>
			      <th scope="col">Description</th>
			      <th scope="col">Status</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody id="result3">
			  	
			  </tbody>
			</table>
		</c:if>
	
<%-- 		Welcome! <span class="fw-bold">${ username }</span> <br /> --%>
		
		<a class="btn btn-primary mt-3 ${ isAdmin?'':'d-none' }" href="/appointments">View Appointments</a> <br />
<!-- 		<a class="btn btn-primary mt-3" href="/profile">View My Profile</a> -->
	</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$.ajax({
			url : "http://localhost:8181/api/getAppointmentsForStudents",
			type : "GET",
			dataType : "json",
			headers: {
		        'Authorization':'Bearer '+JSON.parse(localStorage.getItem("user")).jwtToken
		    },
			success : function(response) {
				response.map((appointment, index) => {
					$("#result2").append(
						"<tr>" +
							"<th scope='row'>"+(index+1)+"</th>" +
							"<td>"+appointment.consultantId+"</td>" +
							"<td>"+appointment.startTime+"</td>" +
							"<td>"+appointment.endTime+"</td>" +
							"<td>"+appointment.description+"</td>" +
							"<td>"+(appointment.status === 0?'PANDING':'APPROVED')+"</td>" +
						"</tr>"
					)
				});
			},
			error : function(xhr, status, error) {
				console.error(xhr.responseText);
			}
		});
		
		$.ajax({
			url : "http://localhost:8181/api/getAppointments",
			type : "GET",
			dataType : "json",
			headers: {
		        'Authorization':'Bearer '+JSON.parse(localStorage.getItem("user")).jwtToken
		    },
			success : function(response) {
				response.map((appointment, index) => {
					$("#result3").append(
						"<tr>" +
							"<th scope='row'>"+(index+1)+"</th>" +
							"<td>"+appointment.studentId+"</td>" +
							"<td>"+appointment.startTime+"</td>" +
							"<td>"+appointment.endTime+"</td>" +
							"<td>"+appointment.description+"</td>" +
							"<td>"+(appointment.status === 0?'PANDING':(appointment.status === 1?'APPROVED':'DISAPPROVED'))+"</td>" +
							"<td><a class='btn btn-primary' href='/change-status/"+appointment.id+"'>Approve / Disapprove</a></td>" +
						"</tr>"
					)
				});
			},
			error : function(xhr, status, error) {
				console.error(xhr.responseText);
			}
		});
		
		$.ajax({
			url : "http://localhost:8181/api/consultant",
			type : "GET",
			dataType : "json",
			headers: {
		        'Authorization':'Bearer '+JSON.parse(localStorage.getItem("user")).jwtToken
		    },
			success : function(response) {
				response.map((user, index) => {
					$("#result").append(
						"<tr>" +
							"<th scope='row'>"+(index+1)+"</th>" +
							"<td>"+user.name+"</td>" +
							"<td>"+user.email+"</td>" +
							"<td>"+user.specification+"</td>" +
							"<td><a class='btn btn-primary' href='/book-appointment/"+user.id+"'>Book</a></td>" +
						"</tr>"
					)
				});
			},
			error : function(xhr, status, error) {
				console.error(xhr.responseText);
			}
		});
	</script>
</body>
</html>