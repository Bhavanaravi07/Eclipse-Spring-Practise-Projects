<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admission</title>
</head>
<body>
	<h2>Enter student details</h2>
	<form:form action="SubmitAdmisssion.html" method="post" commandName="stud1">
	
		<p>ID : <form:input path="id"/> </p>
		
	    <p>Name : <form:input path="name"/> </p>
	    
	    <p>Email : <form:input path="email"/> </p>
	    
	    <p>Mobile : <form:input path="mobile"/></p>
	    
	    <p><input type="submit"> <input type="reset"> </p>
	     
	</form:form>
</body>