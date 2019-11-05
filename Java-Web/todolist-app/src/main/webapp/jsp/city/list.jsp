<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jstl.domain.model.City"%>
<%@page import="com.softtek.academy.jstl.service.CityService"%>
<%@page import="com.softtek.academy.jstl.domain.model.State"%>
<%@page import="com.softtek.academy.jstl.service.StateService"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    static final Logger LOGGER = LoggerFactory.getLogger("StateList");

	CityService cityService = new CityService();
%>
<%
    String  cityId = request.getParameter("cityId");
	if (cityId != null) {
	    cityService.delete(new Long(cityId));
	}
    
	LOGGER.info("Retrieving states:");

	request.setAttribute("cities", cityService.getCities());
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
		</tr>
		<c:forEach var="city" items="${cities}">
			<tr>
				<td>
				    <a href="<c:url value="/jsp/city/edit.jsp?cityId=${city.id}"/>">${city.id}</a>
				</td>
				<td>${city.description}</td>
				<td>${city.state.description}</td>
				<td>
					<a href="<c:url value="/jsp/city/list.jsp?cityId=${city.id}"/>">[ X ]</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<a href="<c:url value="index.jsp"/>">Return to home</a>
	
</body>
</html>
