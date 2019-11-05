<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.commons.lang3.math.NumberUtils"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jstl.domain.model.State"%>
<%@page import="com.softtek.academy.jstl.service.StateService"%>
<%@page import="java.util.List"%>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("StateList");

	StateService stateService = new StateService();
%>
<%
	Long stateId = NumberUtils.createLong(request.getParameter("stateId"));
	if (stateId != null) {
	    stateService.delete(stateId);
	}
	LOGGER.info("Retrieving states...");
	
	request.setAttribute("states", stateService.getStates());
%>

<html>
<head>
	<title>JSTL Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>States</h2>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="state" items="${states}">
			<tr>
				<td><a href="<c:url value="/jsp/state/edit.jsp?stateId=${state.id}"/>">${state.id}</a></td>
				<td>${state.description}</td>
				<td><a href="<c:url value="/jsp/state/list.jsp?stateId=${state.id}"/>">[ X ]</a></td>
			</tr>
        </c:forEach>
	</table>
	
	<br>
	<a href="<c:url value="/index.jsp"/>">Return to home</a>
	
</body>
</html>