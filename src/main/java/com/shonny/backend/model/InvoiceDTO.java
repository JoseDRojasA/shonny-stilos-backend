package com.shonny.backend.model;

import java.util.Date;
import java.util.List;

public class InvoiceDTO {
	private Long id;
	private String serial;
	private Date date;
	private ProviderDTO provider;
	private List<InvoiceProductDTO> invoiceProducts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ProviderDTO getProvider() {
		return provider;
	}
	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}
	public List<InvoiceProductDTO> getInvoiceProducts() {
		return invoiceProducts;
	}
	public void setInvoiceProducts(List<InvoiceProductDTO> invoiceProducts) {
		this.invoiceProducts = invoiceProducts;
	}
}
