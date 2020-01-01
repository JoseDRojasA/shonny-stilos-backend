package com.shonny.backend.model;

public class InvoiceProductDTO {
	private InvoiceProductKeyDTO id;
	private Long buyPricePerUnit;
	private Long pricePerUnit;
	private Integer amount;
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
	public Long getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Long pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
