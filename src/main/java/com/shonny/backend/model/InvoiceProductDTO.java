package com.shonny.backend.model;

public class InvoiceProductDTO {
	private InvoiceProductKeyDTO id;
	private Long buyPricePerUnit;
	private Integer amount;
	private ProductDTO product;
	private InvoiceDTO invoice;
	
	public InvoiceProductKeyDTO getId() {
		return id;
	}
	public void setId(InvoiceProductKeyDTO id) {
		this.id = id;
	}
	public Long getBuyPricePerUnit() {
		return buyPricePerUnit;
	}
	public void setBuyPricePerUnit(Long buyPricePerUnit) {
		this.buyPricePerUnit = buyPricePerUnit;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public InvoiceDTO getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceDTO invoice) {
		this.invoice = invoice;
	}

}
