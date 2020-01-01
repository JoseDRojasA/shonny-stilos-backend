package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.InvoiceProductKeyDTO;

public class InvoiceProductKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_invoice")
	private Long invoice;
	
	@Column(name = "id_product")
	private Long product;

	public Long getInvoice() {
		return invoice;
	}

	public void setInvoice(Long invoice) {
		this.invoice = invoice;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
	
	public static InvoiceProductKey fromDTO(InvoiceProductKeyDTO invoiceProductoKeyDTO) {
		InvoiceProductKey invoiceProductKey = new InvoiceProductKey();
		BeanUtils.copyProperties(invoiceProductoKeyDTO, invoiceProductKey);
		return invoiceProductKey;
	}

	public InvoiceProductKeyDTO toDTO() {
		InvoiceProductKeyDTO invoiceProductKeyDTO = new InvoiceProductKeyDTO();
		BeanUtils.copyProperties(this, invoiceProductKeyDTO);
		return invoiceProductKeyDTO;
	}
}
