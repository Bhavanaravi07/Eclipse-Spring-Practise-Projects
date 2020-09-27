<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	${SPRING_SECURITY_LAST_EXCEPTION.message }
	<form action="login" method="post">
		User name : <input type="text" name="username"><br>
		Password : <input type="password" name="password"><br>
		 <input type="submit" value="Login">


	</form>

</body>
</html>