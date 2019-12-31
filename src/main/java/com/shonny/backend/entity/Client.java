package com.shonny.backend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@NamedQuery(name = "Client.findAll", query = "SELECT a FROM Client a")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_client")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person person;
	
	@Column(name = "white_percentage")
	private Integer whitePercentage;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	private List<CapilarTreatment> capilarTreatment;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getWhitePercentage() {
		return whitePercentage;
	}

	public void setWhitePercentage(Integer whitePercentage) {
		this.whitePercentage = whitePercentage;
	}

	public List<CapilarTreatment> getCapilarTreatment() {
		return capilarTreatment;
	}

	public void setCapilarTreatment(List<CapilarTreatment> capilarTreatment) {
		this.capilarTreatment = capilarTreatment;
	}
}
