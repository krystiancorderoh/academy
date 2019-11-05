<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>JSTL Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>JSTL Application</h2>
	<hr>
	<h3>Examples:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="jsp/state/list.jsp"/>">State List</a></li>
		<li><a href="<c:url value="jsp/state/add.jsp"/>">New State</a></li>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="jsp/city/list.jsp"/>">City List</a></li>
		<li><a href="<c:url value="jsp/city/add.jsp"/>">New City</a></li>
		<li>--------------------------------------------</li>
        <li><a href="<c:url value="jsp/cart/list.jsp"/>">Cart List</a></li>
	</ul>
</body>
</html>
