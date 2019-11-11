package com.softtek.academy.spring.domain.model;

public class User{
	
	int idUser;
	String name;
	String email;
	
	public User() {}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public User(int id, String name, String email) {
		this.idUser = id;
		this.name = name;
		this.email = email;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return this.getName();
	}
	public int compareTo(User usuario) {
		return this.getIdUser() - usuario.getIdUser();
	}

	



}
