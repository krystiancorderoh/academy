package com.softtek.academy.ws.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	public User(String id) {
		this.id = id;
	}

	private String id;

	private String username;

	private String password;

	private String name;

	private UserRole userRole;

	private boolean active;

}
