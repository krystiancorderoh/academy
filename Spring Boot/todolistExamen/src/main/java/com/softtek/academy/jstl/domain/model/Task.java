package com.softtek.academy.jstl.domain.model;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jstl.web.serialize.JsonDateTimeDeserializer;
import com.softtek.academy.jstl.web.serialize.JsonDateTimeSerializer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="Task")
@EqualsAndHashCode(callSuper = false)
public class Task {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "idTask")
	private Long idTask;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creationDate")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	private LocalDateTime creationDate;
	
	@Column(name="dueDate")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	private LocalDateTime dueDate;

	
	
	

}
