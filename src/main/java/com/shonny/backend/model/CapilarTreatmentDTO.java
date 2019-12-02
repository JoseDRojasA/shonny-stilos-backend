package com.shonny.backend.model;

import java.time.LocalDate;

public class CapilarTreatmentDTO {
	private Long id;
	private LocalDate date;
	private String description;
	private String notes;
	private CapilarTreatmentTypeDTO type;
	private Long value;
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
	public CapilarTreatmentTypeDTO getType() {
		return type;
	}
	public void setType(CapilarTreatmentTypeDTO type) {
		this.type = type;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
}
