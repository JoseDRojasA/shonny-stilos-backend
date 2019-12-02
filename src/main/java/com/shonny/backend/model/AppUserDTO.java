package com.shonny.backend.model;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.entity.AppUser;

public class AppUserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private String telephone;
	private PersonDTO person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		BeanUtils.copyProperties(appUser, this);
		return appUser;
	}
}
