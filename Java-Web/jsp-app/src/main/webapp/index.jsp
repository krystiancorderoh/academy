<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
	<title>JSPs Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>Servlets Application</h2>
	<hr>
	<h3>Examples:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<%= contextPath %>/jsp/state/list.jsp">State List</a></li>
		<li><a href="<%= contextPath %>/jsp/state/add.jsp">New State</a></li>
		<li>--------------------------------------------</li>
		<li><a href="<%= contextPath %>/jsp/city/list.jsp">City List</a></li>
		<li><a href="<%= contextPath %>/jsp/city/add.jsp">New City</a></li>
	</ul>
</body>
</html>
