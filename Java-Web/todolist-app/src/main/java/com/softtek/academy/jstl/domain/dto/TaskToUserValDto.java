package com.softtek.academy.jstl.domain.dto;

public class TaskToUserValDto {
	private String userName;
	private String userEmail;
	private String priority;
	private String status;
	
	public TaskToUserValDto() {
		
	}
	
	public TaskToUserValDto(String userName, String userEmail, String priority, String status) {
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.priority = priority;
		this.status = status;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
