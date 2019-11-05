<%@page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    request.setAttribute("errorMsg", exception.getMessage());
    request.setAttribute("errorCause", exception.getCause());
%>

<html>
<head>
<title>JSTL Application</title>
<meta charset="UTF-8">
</head>
<body>
	<h2>Application Error:</h2>

	<div>Error: ${errorMsg}</div>
	<div>Cause: ${errorCause}</div>

	<br>
	<a href="<c:url value="/index.jsp"/>">Return to home</a>

</body>
</html>