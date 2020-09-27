<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>

	<form action="markupdate" method="post">
		<h2>
			Updating Student Information of Id "<%=request.getParameter("id")%>"
		</h2>
		<%
			request.setAttribute("stduentid", request.getParameter("id"));
		%>
		<table>
			<tr>
				<td>StudentId</td>
				<td><input type="text" name="studentid" value="<%=request.getParameter("id")%>" readonly="readonly">
				<td>
			</tr>
			<tr>
				<td>ExamId</td>
				<td><input type="text" name="examid">
				<td>
			</tr>
			<tr>
				<td>Maths</td>
				<td><input type="date" name="mark1">
				<td>
			</tr>
			<tr>
				<td>Physics</td>
				<td><input type="text" name="mark2">
				<td>
			</tr>
			<tr>
				<td>Chemistry</td>
				<td><input type="text" name="mark3">
				<td>
			</tr>

		</table>
		<input type="submit" value="submit"> <input type="reset"
			value="Cancel">
	</form>
</body>
</html>