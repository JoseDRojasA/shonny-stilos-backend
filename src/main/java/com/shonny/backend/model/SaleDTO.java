package com.shonny.backend.model;

import java.util.Date;
import java.util.List;


public class SaleDTO {
	private Long id;
	private String clientName;
	private ClientDTO client;
	private Date date;
	
	private List<SaleProductDTO> saleProducts;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	public List<SaleProductDTO> getSaleProducts() {
		return saleProducts;
	}
	public void setSaleProducts(List<SaleProductDTO> saleProducts) {
		this.saleProducts = saleProducts;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
