package com.shonny.backend.model;

public class ProductDTO {
	private Long id;
	private String name;
	private Long price;
	private Integer amount;
	private Integer minAmount;
	private Boolean active;
	private BrandDTO brand;
	private ProviderDTO provider;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(Integer minAmount) {
		this.minAmount = minAmount;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public BrandDTO getBrand() {
		return brand;
	}
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}
	public ProviderDTO getProvider() {
		return provider;
	}
	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}
	
}
