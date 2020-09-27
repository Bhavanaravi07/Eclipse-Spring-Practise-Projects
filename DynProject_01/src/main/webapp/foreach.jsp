<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>forEach</title>
</head>
<body>
<c:forEach var="counter" begin="1" end="10">
 <c:out value="${counter}"/>
</c:forEach>
</body>
</html>

