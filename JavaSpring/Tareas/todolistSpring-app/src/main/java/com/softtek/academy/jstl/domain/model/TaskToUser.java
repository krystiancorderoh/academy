package com.softtek.academy.jstl.domain.model;

import org.springframework.stereotype.Component;

@Component
public class TaskToUser {

	int idTaskToUser;
	Task task;
	User user;
	Priority priority;
	Status status;
	
	public int getIdTaskToUser() {
		return idTaskToUser;
	}
	
	public void setIdTaskToUser(int idTaskToUser) {
		this.idTaskToUser = idTaskToUser;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
