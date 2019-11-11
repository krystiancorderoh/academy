package com.softtek.academy.jstl.domain.model;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Task {
	
	int idTask;
	String name;
	String description;
	LocalDate creationDate;
	LocalDate dueDate;
	
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", name=" + name + ", description=" + description + ", creationDate="
				+ creationDate + ", dueDate=" + dueDate + "]";
	}
	
	

}
