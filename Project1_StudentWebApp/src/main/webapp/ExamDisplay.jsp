<%@page import="java.text.ParseException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.dxc.dao.ExamJdbcDAO"%>
<%@page import="com.dxc.beans.Exam"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam_Display</title>
</head>
<body>
	<h2>Exam DataBase</h2>

	<table>
		<tr>
			<th>ExamId</th>
			<th>Name</th>
		</tr>
		<%
			List<Exam> exams = new ExamJdbcDAO().findAll();
		for (Exam exam : exams) {
		%>
		<tr>
			<td><%=exam.getEid()%></td>
			<td><%=exam.getEname()%></td>
			<td><a href='editExam.jsp?id=<%=exam.getEid()%>'>Edit</a>/ <a
				href='deleteExam?id=<%=exam.getEid()%>'>Delete</a></td>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	<br>
	<a href="addExam.jsp">Add New Exam</a>
	<br>
	<br>
	<form action="index.jsp">
		<input type="submit" value="Logout">
	</form>

</body>
</html>