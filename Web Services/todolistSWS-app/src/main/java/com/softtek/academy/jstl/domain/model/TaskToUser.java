package com.softtek.academy.jstl.domain.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TaskToUser {

	int idTaskToUser;
	Task task;
	User user;
	Priority priority;
	Status status;
	
	
}
