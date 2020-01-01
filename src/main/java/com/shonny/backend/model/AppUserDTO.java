package com.shonny.backend.model;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.entity.AppUser;

public class AppUserDTO {
	
	private Long id;
	private String username;
	private String password;
	private Boolean isAdmin;
	private PersonDTO person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public AppUser toEntity() {
		AppUser appUser = new AppUser();
		BeanUtils.copyProperties(this, appUser);
		return appUser;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
