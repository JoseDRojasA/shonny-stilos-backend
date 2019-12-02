package com.shonny.backend.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.shonny.backend.model.PersonDTO;

@Entity
@Table(name = "person")
@NamedQuery(name = "Person.findAll", query = "SELECT a FROM Person a")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_person")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public PersonDTO toDTO() {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setEmail(email);
		personDTO.setId(id);
		personDTO.setLastName(lastName);
		personDTO.setName(lastName);
		personDTO.setTelephone(telephone);
		personDTO.setBirthdate(birthdate);
		return personDTO;
	}
	
}
