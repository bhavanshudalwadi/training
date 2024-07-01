<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h1>Index Page</h1>
	<p>Welcome! ${username}</p>
	<c:if test="${username != null}">
		<a href="/profile/${username.equals("admin")?2:1}">View Profile</a>
	</c:if>	
	<p>${sjfhgdh}</p>
</body>
</html>