package com.shonny.backend.model;

public class InvoiceProductKeyDTO {
	private Long invoice;
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
