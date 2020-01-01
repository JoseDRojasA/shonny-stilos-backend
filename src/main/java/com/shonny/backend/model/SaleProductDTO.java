package com.shonny.backend.model;

public class SaleProductDTO {
	
	private SaleProductKeyDTO id;
	private SaleDTO sale;
	private ProductDTO product;
	private Long buyPrice;
	private Long price;
	private Long amount;
	private Long discount;
	
	public SaleProductKeyDTO getId() {
		return id;
	}
	public void setId(SaleProductKeyDTO id) {
		this.id = id;
	}
	public SaleDTO getSale() {
		return sale;
	}
	public void setSale(SaleDTO sale) {
		this.sale = sale;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Long getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
}
