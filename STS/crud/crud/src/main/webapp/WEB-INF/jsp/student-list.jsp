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
<div class="container mt-5">
	<div class="text-end">
		<a class="btn btn-primary mb-3" href="/add-student">Add Student</a>
	</div>
	<table class="table table-striped table-hover">
	  <thead class="table-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Enrollment No</th>
	      <th scope="col">Email</th>
	      <th scope="col">Phone</th>
	      <th scope="col">Actions</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${students}" var="student">
			<tr>
		      <th scope="row"><c:out value="${student.id}"/></th>
		      <td><c:out value="${student.name}"/></td>
		      <td><c:out value="${student.enno}"/></td>
		      <td><c:out value="${student.email}"/></td>
		      <td><c:out value="${student.phone}"/></td>
		      <td><a class="btn btn-primary" href="/edit-student/${student.id}">&#9998;</a>
		      <a class="btn btn-primary" href="/delete-student/${student.id}">&#128465;</a></td>
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
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>