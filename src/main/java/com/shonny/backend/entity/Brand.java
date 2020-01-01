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
import com.shonny.backend.model.BrandDTO;
@Entity
@Table(name = "brand")
@NamedQuery(name = "Brand.findAll", query = "SELECT a FROM Brand a")
public class Brand implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_brand")
	private Integer id;
	
	@Column(nullable = false)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public BrandDTO toDTO() {
		BrandDTO brandDTO = new BrandDTO();
		BeanUtils.copyProperties(this, brandDTO);
		return brandDTO;
	}

	public static Brand fromDTO(BrandDTO brandDTO) {
		Brand brand = new Brand();
		BeanUtils.copyProperties(brandDTO, brand);
		return brand;
	}
}
