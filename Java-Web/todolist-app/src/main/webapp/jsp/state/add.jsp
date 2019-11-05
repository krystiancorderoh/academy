<%@page import="org.apache.commons.lang3.math.NumberUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.softtek.academy.jstl.exception.InvalidInputException"%>
<%@page import="com.softtek.academy.jstl.domain.model.State"%>
<%@page import="com.softtek.academy.jstl.service.StateService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="java.util.List"%>

<%!
    static final Logger LOGGER = LoggerFactory.getLogger("StateAdd");

	StateService stateService = new StateService();
%>
<%
    String msg = StringUtils.EMPTY;
    String disabled = StringUtils.EMPTY;
    State state = null;

    if (request.getParameter("save") == null) {
        state = new State(null, StringUtils.EMPTY);

    } else {
        String stateDesc = request.getParameter("description");
        try {
            LOGGER.info("Saving: {}", stateDesc);
        
            state = stateService.save(stateDesc);
            
            msg = "Saved successfully";
            disabled = "disabled";

        } catch (InvalidInputException e) {
            msg = e.getMessage();
        }
    }

    request.setAttribute("msg", msg);
    request.setAttribute("disabled", disabled);
    request.setAttribute("state", state);
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
                <td width="70%"><input type="text" name="id" value="${state.id}" disabled></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="${state.description}" ${disabled}></td>
            </tr>
        </table>
        <input type="submit" name="save" ${disabled}>
    </form>

	<br>
	<div>${msg}</div>

	<br>
	<a href="<c:url value="/index.jsp"/>">Return to home</a>
</body>
</html>