<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.dxc.dao.StudentJdbcDAO"%>
<%@page import="com.dxc.beans.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
	<h2>Student DataBase</h2>
	<table>
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Dob</th>
	<th>Email</th>
	<th>Mobile</th>
	</tr>
	<%
	List<Student> students=new StudentJdbcDAO().findAll();
	for(Student student : students)
	{
		%>
		<tr>
		<form action="Edit.jsp" method="post">
		<td><%= student.getId()%></td>
		</form>
		<td><%= student.getName()%></td>
		<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			%>
		<td><%=sdf.format(student.getDob())%></td>
		<td><%=student.getEmail()%></td>
		<td><%=student.getMobile() %></td>		
		<td><a href='Edit.jsp?id=<%=student.getId()%>'>Edit</a>/<a href='delete?id=<%=student.getId()%>'>Delete</a></td></td>
		</tr>
		<%
	}
	%>
	</table>
		<br><a href="addStudent.jsp">Add New Student</a><br><br>
	<form action="index.jsp">
		<input type="submit" value="Logout">
	</form>
	

</body>
</html>