<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Student Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Student
</h1>

<c:url var="addAction" value="/student/add" ></c:url>

<form:form action="${addAction}" commandName="person">
<table>
	<c:if test="${!empty student.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty student.name}">
				<input type="submit"
					value="<spring:message text="Edit"/>" />
			</c:if>
			<c:if test="${empty student.name}">
				<input type="submit"
					value="<spring:message text="Add"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Student List</h3>
<c:if test="${!empty listStudents}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120"> Name</th>
		<th width="120">Email</th>
		<th width="120">Mobile</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listStudents}" var="student">
		<tr>
			<td>${student.studentid}</td>
			<td>${student.name}</td>
			<td>${student.email}</td>
			<td>${student.mobile}</td>
			<td><a href="<c:url value='/edit/${student.studentid}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.studentid}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
