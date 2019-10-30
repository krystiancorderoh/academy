<%@page import="com.softtek.academy.jsp.domain.dto.CityDto"%>
<%@page import="com.softtek.academy.jsp.web.mapping.EntityMapper"%>
<%@page import="com.softtek.academy.jsp.web.mapping.CityMapper"%>
<%@page import="com.softtek.academy.jsp.service.CityService"%>
<%@page import="com.softtek.academy.jsp.domain.model.CityEntity"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.softtek.academy.jsp.exception.InvalidInputException"%>
<%@page import="com.softtek.academy.jsp.domain.model.StateEntity"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="java.util.List"%>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("CityAdd");

	EntityMapper<CityDto> cityMapper = new CityMapper();
	CityService cityService = new CityService();
	StateService stateService = new StateService();
%>
    
<%    
    String msg = StringUtils.EMPTY;
    String disabled = StringUtils.EMPTY;

    CityDto cityDto = null;

    if (request.getParameter("save") == null) {
        //cityDto = new CityDto(null, StringUtils.EMPTY, null);
        long idCity = Long.parseLong(request.getParameter("cityId"));
    	cityDto = cityService.getCity(idCity);

    } else {
       cityDto = cityMapper.mapEntity(request);
        try {
            LOGGER.info("Saving: {}", cityDto);

            cityService.save(cityDto);
            msg = "Saved successfully";
            
        } catch (InvalidInputException e) {
            msg = e.getMessage();
        }
    }
    
    List<StateEntity> states = stateService.getStates();
    
    String contextPath = request.getContextPath();
%>

<html>
<head>
<title>Cities</title>
<meta charset="UTF-8">
</head>
<body>
	<h3>New City</h3>

	<form method="post" action="">
		<table style="width: 30%;">
			<tr>
				<td width="30%">Id</td>
				<td width="70%"><input type="text" name="id" value="<%=cityDto.getId()%>" readonly ></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"value="<%=cityDto.getDescription()%>" ></td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<select name="stateId" > <% 
						for (StateEntity state : states) { %>
						    <option value="<%= state.getId() %>" <%= state.getId().equals(cityDto.getStateId()) ? "selected" : StringUtils.EMPTY %>>
						    	<%= state.getDescription() %>
						    </option> <%
						}						
					%></select>
				</td>
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