<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>List Of Students</title>
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
<div class="container mt-5">
	<div class="text-end">
		<a class="btn btn-primary mb-3" href="/user/add">Add User</a>
	</div>
	<table class="table table-striped table-hover">
	  <thead class="table-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Phone</th>
	      <th scope="col">Roles</th>
	      <th scope="col">Qualification</th>
	      <th scope="col">Company Name</th>
	      <th scope="col">Bio</th>
	      <th scope="col">Address(City, State, Country)</th>
	      <th scope="col">Actions</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${users}" var="user">
			<tr>
		      <th scope="row"><c:out value="${user.id}"/></th>
		      <td><c:out value="${user.name != null?user.name:'---'}"/></td>
		      <td><c:out value="${user.email != null?user.email:'---'}"/></td>
		      <td><c:out value="${user.phone != null?user.phone:'---'}"/></td>
		      <td><c:out value="${user.roles != null?user.roles:'---'}"/></td>
		      <td><c:out value="${user.education != null?user.education:'---'}"/></td>
		      <td><c:out value="${user.company != null?user.company:'---'}"/></td>
		      <td>${user.bio != null?user.bio:'---'}</td>
		      <td id="address-${user.id}"></td>
		      <td><a class="btn btn-primary" href="/user/edit/${user.id}">&#9998;</a>
<%-- 		      <a class="btn btn-primary" href="/user/delete/${user.id}">&#128465;</a> --%>
		      <button class="btn btn-primary" onclick="deleteUser(${user.id},'${user.name}')">&#128465;</button> </td>
		    </tr> 
    	</c:forEach>
    	<c:if test="${students.size() <= 0}">
    		<tr>
    			<td class="text-center" colspan="6">No Records Found</td>
    		</tr> 
    	</c:if>
	  </tbody>
	</table>
	</div>
	<script>
		const deleteUser = (id, name) => {
			if(confirm('Are you sure want to delete user named `'+name+'`')) {
				window.location.href = '/user/delete/'+id;
			}
		}
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		var countries = [];
		var states = [];
		var cities = [];
		
		$(document).ready(function(){
             $.ajax({
                 url: "http://localhost:8181/countries.json",
                 type: "GET",
                 dataType: "json",
                 success: function(response) {
                 	countries = response;
                 },
                 error: function(xhr, status, error) {
                     console.error(xhr.responseText);
                 }
             });
             
           	 $.ajax({
                 url: "http://localhost:8181/states.json",
                 type: "GET",
                 dataType: "json",
                 success: function(response) {
                 	states = response;
                 },
                 error: function(xhr, status, error) {
                     console.error(xhr.responseText);
                 }
             });  
            	
           	 $.ajax({
                 url: "http://localhost:8181/cities.json",
                 type: "GET",
                 dataType: "json",
                 success: function(response) {
                 	cities = response;
                 	setAddresses();
                 },
                 error: function(xhr, status, error) {
                     console.error(xhr.responseText);
                 }
             });
        });
		
	</script>
	
	<script>
		function setAddresses() {		
			const getCountry = (id) => countries.find(country => country.id == id)?.name;
			const getState = (id) => states.find(state => state.id == id)?.name;
			const getCity = (id) => cities.find(city => city.id == id)?.name;
			
			let userArr = ${users.toString()};
			
			userArr.filter(user => {
				const addressTag = document.getElementById("address-"+user.id);
				let country = getCountry(user.country) != undefined?getCountry(user.country):'';
				let state = getState(user.state) != undefined?getState(user.state):'' ;
				let city = getCity(user.city) != undefined?getCity(user.city):'' ;
				addressTag.innerHTML = country + ", " + state + ", " + city;
			})
		}
	</script>
</body>
</html>