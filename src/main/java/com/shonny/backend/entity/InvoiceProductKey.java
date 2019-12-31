package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;

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
}
