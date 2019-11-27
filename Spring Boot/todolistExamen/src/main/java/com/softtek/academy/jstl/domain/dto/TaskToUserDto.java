package com.softtek.academy.jstl.domain.dto;


import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class TaskToUserDto {
	
	private int idTask;
	private int idUser;
	private int idPriority;
	private int idStatus;
	

}
