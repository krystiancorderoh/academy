<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jsp.domain.model.CityEntity"%>
<%@page import="com.softtek.academy.jsp.service.CityService"%>
<%@page import="com.softtek.academy.jsp.domain.model.StateEntity"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="java.util.List"%>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("StateList");

	CityService cityService = new CityService(); 
%>
<%
	String cityIdParam = request.getParameter("cityId");
	if (cityIdParam != null) {
	    cityService.delete(new Long(cityIdParam));
	}

	LOGGER.info("Retrieving states:");

	List<CityEntity> cities = cityService.getCities();
%>

<html>
<head>
	<title>JSPs Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>Cities</h2>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>State</th>
			<th>Delete</th>
		</tr><%
		
		for (final CityEntity city : cities) { %>
			<tr>
				<td>
					<a href="edit.jsp?cityId=<%= city.getId() %>"><%= city.getId() %></a>
				</td>
				<td><%= city.getDescription() %></td>
				<td><%= city.getState().getDescription() %></td>
				<td>
					[ <a href="list.jsp?cityId=<%= city.getId() %>">X</a> ]
				</td>
			</tr><%
		}
		
	%></table>
	
	<br>
	<a href="<%= request.getContextPath() %>/index.jsp">Return to home</a>
	
</body>
</html>
