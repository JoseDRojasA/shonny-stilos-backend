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

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.InvoiceProductDTO;

@Entity
@Table(name = "invoice_product")
@NamedQuery(name = "InvoiceProduct.findAll", query = "SELECT a FROM InvoiceProduct a")
public class InvoiceProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @EmbeddedId
    InvoiceProductKey id;
    
    @MapsId("id_invoice")
	@ManyToOne(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "id_invoice")
	private Invoice invoice;
	
    @MapsId("id_product")
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
    
	@Column(name = "buy_price_per_unit", nullable = false)
	private Long buyPricePerUnit;
	
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
	public Long getBuyPricePerUnit() {
		return buyPricePerUnit;
	}
	public void setBuyPricePerUnit(Long buyPricePerUnit) {
		this.buyPricePerUnit = buyPricePerUnit;
	}
	
	public static InvoiceProduct fromDTO(InvoiceProductDTO invoiceProductoDTO) {
		InvoiceProduct invoiceProduct = new InvoiceProduct();
		BeanUtils.copyProperties(invoiceProductoDTO, invoiceProduct);
		if (invoiceProductoDTO.getId() != null) {
			invoiceProduct.setId(InvoiceProductKey.fromDTO(invoiceProductoDTO.getId()));
		}
		if (invoiceProductoDTO.getInvoice() != null) {
			invoiceProduct.setInvoice(Invoice.fromDTO(invoiceProductoDTO.getInvoice()));
		}
		if (invoiceProductoDTO.getProduct() != null) {
			invoiceProduct.setProduct(Product.fromDTO(invoiceProductoDTO.getProduct()));
		}
		return invoiceProduct;
	}
	
	public InvoiceProductDTO toDTO() {
		InvoiceProductDTO invoiceProductDTO = new InvoiceProductDTO();
		BeanUtils.copyProperties(this, invoiceProductDTO);
		if (id != null) {
			invoiceProductDTO.setId(id.toDTO());
		}
		return invoiceProductDTO;
	}
}
