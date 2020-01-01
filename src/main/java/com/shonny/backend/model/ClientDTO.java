package com.shonny.backend.model;

import java.util.List;

public class ClientDTO {
	
	private PersonDTO person;
	private Integer whitePercentage;
	private List<CapilarTreatmentDTO> capilarTreatment;
	
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public Integer getWhitePercentage() {
		return whitePercentage;
	}
	public void setWhitePercentage(Integer whitePercentage) {
		this.whitePercentage = whitePercentage;
	}
	public List<CapilarTreatmentDTO> getCapilarTreatment() {
		return capilarTreatment;
	}
	public void setCapilarTreatment(List<CapilarTreatmentDTO> capilarTreatment) {
		this.capilarTreatment = capilarTreatment;
	}
}
