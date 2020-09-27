<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showStudentForm</title>
</head>
<body>
	<h2>Enter Student Data</h2>
	<form action="addStudent" method="post">
	ID : <input type="text" name="id"><br>
	NAME : <input type="text" name="name"><br>
	EMAIL : <input type="text" name="email"><br>
	MOBILE : <input type="text" name="mobile"><br>
	<input type="submit" value="Insert">
	</form>
</body>
</html>