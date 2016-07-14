<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dextra Coder</title>
</head>
<body>

<h1>Acceso a usuario</h1>
<c:if test="${param.error != null}">
	<p> Invalid username / password </p>
</c:if>

<form action="j_spring_security_check" method="post">
	<table>
		<tr>
			<td>Usuario: </td>
			<td><input type="text" name="user" value=""></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="pwd" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>