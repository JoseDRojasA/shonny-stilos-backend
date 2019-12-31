package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.AppUserDTO;

@Entity
@Table(name = "app_user")
@NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a")
public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_app_user")
	private Integer id;
	
	@Column(name="username", nullable = false, unique = true)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_person")
	private Person person;
	
	@Column(name="is_admin")
	private boolean isAdmin;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AppUserDTO toDTO() {
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setId(id);
		appUserDTO.setUsername(username);
		if (person != null) {
			appUserDTO.setPerson(person.toDTO());
		}
		appUserDTO.setIsAdmin(isAdmin);
		return appUserDTO;
	}

	public static AppUser fromDTO(AppUserDTO userDTO) {
		AppUser user = new AppUser();
		BeanUtils.copyProperties(user, userDTO);
		return user;
	}
}
