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
		Welcome! <span class="fw-bold">${ username }</span> <br />
		
		<a class="btn btn-primary mt-3 ${ isAdmin?'':'d-none' }" href="/user/list">View Userlist</a> <br />
		<a class="btn btn-primary mt-3" href="/profile">View My Profile</a>
	</div>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>