<%@page import="com.softtek.academy.jstl.domain.dto.CityDto"%>
<%@page import="com.softtek.academy.jstl.web.mapping.EntityMapper"%>
<%@page import="com.softtek.academy.jstl.web.mapping.CityMapper"%>
<%@page import="com.softtek.academy.jstl.service.CityService"%>
<%@page import="com.softtek.academy.jstl.domain.model.City"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.softtek.academy.jstl.exception.InvalidInputException"%>
<%@page import="com.softtek.academy.jstl.domain.model.State"%>
<%@page import="com.softtek.academy.jstl.service.StateService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
	static final Logger LOGGER = LoggerFactory.getLogger("CityAdd");

	CityService cityService = new CityService();
	StateService stateService = new StateService();
%>
    
<%    
    String msg = StringUtils.EMPTY;
    String disabled = StringUtils.EMPTY;

    City city = null;
    CityDto cityDto = null;

    if (request.getParameter("save") == null) {
        
    	long idCity = Long.parseLong(request.getParameter("cityId"));
    	
    	city = cityService.getCity(idCity);

    } else {
    	long idCity = Long.parseLong(request.getParameter("cityId"));
    	city = cityService.getCity(idCity);
    	cityDto = new CityDto(request.getParameter("description"),new Long (request.getParameter("stateId")));
        try {
            LOGGER.info("Saving: {}", cityDto);

            city = cityService.update(city.getId(),cityDto);
            msg = "Saved successfully";
            
        } catch (InvalidInputException e) {
            msg = e.getMessage();
        }
    }
    
    request.setAttribute("states", stateService.getStates());
    request.setAttribute("city", city);
     
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
				<td width="70%"><input type="text" name="id" value="${city.id }" readonly ></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"value="${city.description }" ></td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<select name="stateId" ${disabled}>  
						<c:forEach var="state" items="${states}">
						    <option value="${state.id}" <c:if test= "${state.id == city.state.id}">selected</c:if>>${state.description}</option>       
						</c:forEach>
					</select>
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