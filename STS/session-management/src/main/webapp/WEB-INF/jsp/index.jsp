<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h1>Index Page</h1>
	
	<form action="/addSession" method="post">
		<input name="msg" type="text" placeholder="Enter Session Message"/>
		<input type="submit" value="Add To Session" />
	</form>
	
	<h5>Session Contains:</h5>
	<c:forEach items="${sessionMessages}" var="session">
		<c:out value="${session}"/> <br />
	</c:forEach>
</body>
</html>