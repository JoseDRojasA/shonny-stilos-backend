package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.ProviderDTO;

@Entity
@Table(name = "provider")
@NamedQuery(name = "Provider.findAll", query = "SELECT a FROM Provider a")
public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_provider")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String consultant;
	
	@Column(name="consultant_number", nullable = false)
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
	public static Provider fromDTO(ProviderDTO providerDTO) {
		Provider provider = new Provider();
		BeanUtils.copyProperties(providerDTO, provider);
		return provider;
	}
	public ProviderDTO toDTO() {
		ProviderDTO providerDTO = new ProviderDTO();
		BeanUtils.copyProperties(this, providerDTO);
		return providerDTO;
	}
	
}
