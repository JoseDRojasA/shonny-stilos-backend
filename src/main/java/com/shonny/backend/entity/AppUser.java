package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
	private Long id;
	
	@Column(name="username", nullable = false, unique = true)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@OneToOne()
	@JoinColumn(name = "id_person")
	private Person person;
	
	@Column(name="is_admin")
	private Boolean isAdmin;

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

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AppUserDTO toDTO() {
		AppUserDTO appUserDTO = new AppUserDTO();
		BeanUtils.copyProperties(this, appUserDTO);
		if (person != null) {
			appUserDTO.setPerson(person.toDTO());
		}
		return appUserDTO;
	}

	public static AppUser fromDTO(AppUserDTO userDTO) {
		AppUser user = new AppUser();
		BeanUtils.copyProperties(userDTO, user);
		if(userDTO.getPerson() != null) {
			Person person = new Person();
			BeanUtils.copyProperties(userDTO.getPerson(), person);
			user.setPerson(person);
		}
		return user;
	}
}
