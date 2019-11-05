<%@page import="com.softtek.academy.jstl.domain.dto.TaskToUserValDto"%>
<%@page import="com.softtek.academy.jstl.service.TaskToUserValDtoService"%>
<%@page import="com.softtek.academy.jstl.service.TaskService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jstl.domain.model.Task"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%!
    static final Logger LOGGER = LoggerFactory.getLogger("StateList");

	TaskService taskService = new TaskService();
	TaskToUserValDtoService taskToUserValDtoService = new TaskToUserValDtoService();
%>
<%
    String  taskId = request.getParameter("taskId");
	Task task= null;
	
	if (taskId != null) {
	    task = taskService.getTask(new Integer(taskId));
	    request.setAttribute("taskToUserValDtos", taskToUserValDtoService.getTaskToUserValDto(task.getIdTask()));
	}
    
	LOGGER.info("Retrieving states:");

	request.setAttribute("tasks", taskService.getTasks());
	request.setAttribute("task", task);
	
%>
<html>
<head>
	<title>ToDoList Application</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>ToDoList Application</h2>
	<hr>
	<h3>Task Management:</h3>
	
	<table border="1">
		<tr>
			<th>Task</th>
			<th>Detail</th>
			
		</tr>
		<tr>
				<td>
				<ul>
					<c:forEach var="task" items="${tasks}">
						<li><a href="<c:url value="index.jsp?taskId=${task.idTask}"/>">${task.idTask}:${task.name}</a></li>
					</c:forEach>
				</ul>
				</td>
				<td>
					<table border="0">
						<tr>
							<td>Task: ${task.idTask}:${task.name}</td>
							<td>Creation Date: ${task.creationDate}</td>
						</tr>
						<tr>
							<td>Description: ${task.description}</td>
							<td>Due Date: ${task.dueDate}</td>
						</tr>
						
						<tr>
							<td colspan="2"> <br>Assignaments: New</td>
							
						</tr>
						
						<tr>
							<td colspan="2">
								<table border="1">
									<tr>
										<td>Name</td>
										<td>Email</td>
										<td>Priority</td>
										<td>Status</td>
										<td>Remove</td>
									</tr>
									<c:forEach var="taskToUserValDto" items="${taskToUserValDtos}">
										<tr>
											<td>${taskToUserValDto.userName}</td>
											<td>${taskToUserValDto.userEmail}</td>
											<td>${taskToUserValDto.priority}</td>
											<td>${taskToUserValDto.status}</td>
											<td>X</td>
										</tr>
									</c:forEach>	
									
								</table>
							</td>
						</tr>
					</table>
				</td>
		</tr>
		</table>
		
		
		
</body>
</html>
