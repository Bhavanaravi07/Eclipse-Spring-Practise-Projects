<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>if</title>
</head>
<body>
<c:set var="marks" value="78"/>
<c:if test="${marks >= 35">
 <c:out value="you are pass"/>
</c:if>
<c:if test="${marks < 35">
 <c:out value="You are fail"/>
</c:if>

</body>
</html>