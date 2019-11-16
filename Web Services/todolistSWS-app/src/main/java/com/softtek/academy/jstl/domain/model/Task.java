package com.softtek.academy.jstl.domain.model;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jstl.web.serialize.JsonDateTimeDeserializer;
import com.softtek.academy.jstl.web.serialize.JsonDateTimeSerializer;

import lombok.Data;
@Component
@Data
public class Task {
	
	private int idTask;
	private String name;
	private String description;
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	private LocalDateTime creationDate;
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	private LocalDateTime dueDate;

}
