<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jsp.domain.model.StateEntity"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="java.util.List"%>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("StateList");

	StateService stateService = new StateService();
%>
<%
	LOGGER.info("Retrieving states:");

	List<StateEntity> states = stateService.getStates();
%>
<html>
<head>
	<title>JSPs Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>States</h2>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Description</th>
		</tr><%
		
		for (final StateEntity state : states) { %>
			<tr>
				<td><%= state.getId() %></td>
				<td><%= state.getDescription() %></td>
			</tr><%
		}
		%>
	</table>
	
	<br>
	<a href="<%= request.getContextPath() %>/index.jsp">Return to home</a>
	
</body>
</html>
