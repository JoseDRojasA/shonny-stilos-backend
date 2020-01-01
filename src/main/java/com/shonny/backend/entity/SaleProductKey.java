package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.SaleProductKeyDTO;

public class SaleProductKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_sale")
	private Long sale;
	
	@Column(name = "id_product")
	private Long product;

	public Long getSale() {
		return sale;
	}

	public void setSale(Long sale) {
		this.sale = sale;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
	
	public static SaleProductKey fromDTO(SaleProductKeyDTO saleProductDTO) {
		SaleProductKey saleProductKey = new SaleProductKey();
		BeanUtils.copyProperties(saleProductDTO, saleProductKey);
		return saleProductKey;
	}
	
	public SaleProductKeyDTO toDTO() {
		SaleProductKeyDTO saleProductKeyDTO = new SaleProductKeyDTO();
		BeanUtils.copyProperties(this, saleProductKeyDTO);
		return saleProductKeyDTO;
	}
}
