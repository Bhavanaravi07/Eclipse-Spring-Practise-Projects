<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
	<h2>Welcome</h2>
	<a href="showStudentForm">Add new student data</a><br>
	<br>
	<form action="getStudent">
		Enter student id to display :<input type="text" name="id">
		<input type="submit" value="Display">
	</form>
</body>
</html>


