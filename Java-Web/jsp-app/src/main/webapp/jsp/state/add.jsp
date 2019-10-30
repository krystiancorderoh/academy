<%@page import="com.softtek.academy.jsp.web.mapping.StateMapper"%>
<%@page import="com.softtek.academy.jsp.web.mapping.EntityMapper"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.softtek.academy.jsp.exception.InvalidInputException"%>
<%@page import="com.softtek.academy.jsp.domain.model.StateEntity"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="java.util.List"%>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("StateAdd");

    StateService stateService = new StateService();
    EntityMapper<StateEntity> stateMapper = new StateMapper();%>
<%
    String contextPath = request.getContextPath();
    String msg = "";
    String disabled = "";

    StateEntity state = null;

    if (request.getParameter("save") == null) {
        state = new StateEntity(null, StringUtils.EMPTY);

    } else {
        state = stateMapper.mapEntity(request);
        try {
		    LOGGER.info("Saving: {}", state);
		
		    state = stateService.save(state);
		    msg = "Saved successfully";
		    disabled = "disabled";

        } catch (InvalidInputException e) {
            msg = e.getMessage();
        }
    }
%>

<html>
<head>
<title>States</title>
<meta charset="UTF-8">
</head>
<body>
	<h3>New State</h3>

	<form method="post" action="">
		<table style="width: 40%;">
			<tr>
				<td width="30%">Id</td>
				<td width="70%"><input type="text" name="id" value="<%=state.getId()%>" <%=disabled%>></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"value="<%=state.getDescription()%>" <%=disabled%>></td>
			</tr>
		</table>
		<input type="submit" name="save" <%=disabled%>>
	</form>

	<br>
	<div><%=msg%></div>

	<br>
	<a href="<%=contextPath%>/index.jsp">Return to home</a>
</body>
</html>