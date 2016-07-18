<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" type="text/css">
<title>Dextra Code Skills</title>
</head>
<body>
<div class="wrapper">
	<h1>Register</h1>
	<c:out value="${status}"></c:out>
	
	<sf:form action="${pageContext.request.contextPath}/register/save" method="post" commandName="newUser">
		<div class="form-group">
			<label for="username">Username</label>
			<sf:input type="text" path="name" value="" class="form-control" placeholder="Your name"></sf:input>
			
			<label for="password">Password</label>	
			<sf:password path="password" class="form-control"></sf:password>
			<input type="submit" name="submit" value="submit" class="btn btn-default">
		</div>
	</sf:form>
	<a href="${pageContext.request.contextPath}/login">Return to Login</a>
</div>
</body>
</html>