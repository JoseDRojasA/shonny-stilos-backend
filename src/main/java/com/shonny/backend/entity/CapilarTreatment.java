package com.shonny.backend.entity;

import java.io.Serializable;
import java.time.LocalDate;

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

@Entity
@Table(name = "capilar_treatment")
@NamedQuery(name = "CapilarTreatment.findAll", query = "SELECT a FROM CapilarTreatment a")
public class CapilarTreatment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_capilar_treatment")
	private Long id;
	
	@Column(name="date", nullable = false)
	private LocalDate date;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="notes")
	private String notes;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_type", nullable = false)
	private CapilarTreatmentType type;
	
	@Column(name="value", nullable = false)
	private Long value;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_client", nullable = false)
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public CapilarTreatmentType getType() {
		return type;
	}

	public void setType(CapilarTreatmentType type) {
		this.type = type;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
