package com.shonny.backend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_product")
@NamedQuery(name = "InvoiceProduct.findAll", query = "SELECT a FROM InvoiceProduct a")
public class InvoiceProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @EmbeddedId
    InvoiceProductKey id;
    
    @MapsId("id_invoice")
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_invoice")
	private Invoice invoice;
	
    @MapsId("id_product")
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
	
	@Column(name = "price_per_unit", nullable = false)
	private Long pricePerUnit;
	
	@Column(name = "amount", nullable = false)
	private Integer amount;
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	public InvoiceProductKey getId() {
		return id;
	}
	public void setId(InvoiceProductKey id) {
		this.id = id;
	}
	
}
