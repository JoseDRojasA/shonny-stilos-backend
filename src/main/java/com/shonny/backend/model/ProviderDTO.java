package com.shonny.backend.model;

public class ProviderDTO {
	private Long id;
	private String name;
	private String consultant;
	private String consultantNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsultant() {
		return consultant;
	}
	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	public String getConsultantNumber() {
		return consultantNumber;
	}
	public void setConsultantNumber(String consultantNumber) {
		this.consultantNumber = consultantNumber;
	}
}
