package com.shonny.backend.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

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
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "allergies")
	private String allergies;

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
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public PersonDTO toDTO() {
		PersonDTO personDTO = new PersonDTO();
		BeanUtils.copyProperties(personDTO, this);
		return personDTO;
	}
	
}
