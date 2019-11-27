package com.softtek.academy.jstl.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name="TaskToUser")
@EqualsAndHashCode(callSuper = false)
public class TaskToUser {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "idTaskToUser")
	private Long idTaskToUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTask", referencedColumnName = "idTask")
	private Task task;
	
	@Column(name="idUser")
	private int idUser;
	
	@Column(name="idPriority")
	private int idPriority;
	
	@Column(name="idStatus")
	private int idStatus;
	
	
}
