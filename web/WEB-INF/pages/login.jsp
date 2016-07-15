<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" type="text/css">
<title>Dextra Code Skills</title>
</head>
<body>
<div class="wrapper">
	<h1>Login Access</h1>
	<c:if test="${param.error != null}">
		<p> Invalid username / password </p>
	</c:if>
	
	<form action="j_spring_security_check" method="post">
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" name="user" value="" class="form-control" placeholder="Username">
			
			<label for="password">Password</label>	
			<input type="password" name="pwd" class="form-control" placeholder="Password"/>
			<input type="submit" name="submit" value="submit" class="btn btn-default">
		</div>
	</form>
</div>
</body>
</html>