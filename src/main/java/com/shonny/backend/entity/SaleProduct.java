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
@Table(name = "sale_product")
@NamedQuery(name = "SaleProduct.findAll", query = "SELECT a FROM SaleProduct a")
public class SaleProduct implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaleProductKey id;
	
    @MapsId("id_sale")
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_sale")
	private Sale sale;
    
    @MapsId("id_product")
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
    
	@Column(nullable = false)
	private Long price;
	
	@Column(nullable = false)
	private Long amount;
	
	@Column(nullable = false)
	private Long discount;
	
	public SaleProductKey getId() {
		return id;
	}
	public void setId(SaleProductKey id) {
		this.id = id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
