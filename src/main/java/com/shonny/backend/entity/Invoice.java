package com.shonny.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.InvoiceDTO;
import com.shonny.backend.model.InvoiceProductDTO;

@Entity
@Table(name = "invoice")
@NamedQuery(name = "Invoice.findAll", query = "SELECT a FROM Invoice a")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_invoice")
	private Long id;
	
	@Column(nullable = false)
	private String serial;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_provider" , nullable = false)
	private Provider provider;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH}, mappedBy = "invoice")
	private List<InvoiceProduct> invoiceProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<InvoiceProduct> getInvoiceProducts() {
		return invoiceProducts;
	}

	public void setInvoiceProducts(List<InvoiceProduct> invoiceProducts) {
		this.invoiceProducts = invoiceProducts;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public InvoiceDTO toDTO() {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		BeanUtils.copyProperties(this, invoiceDTO);
		if (provider != null) {
			invoiceDTO.setProvider(provider.toDTO());
		}
		if (getInvoiceProducts() != null) {
			List<InvoiceProductDTO> invoiceProducts = getInvoiceProducts()
					.parallelStream()
					.map(InvoiceProduct::toDTO)
					.collect(Collectors.toList());
			invoiceDTO.setInvoiceProducts(invoiceProducts);
		}
		return invoiceDTO;
	}

	public static Invoice fromDTO(InvoiceDTO invoiceDTO) {
		Invoice invoice = new Invoice();
		BeanUtils.copyProperties(invoiceDTO, invoice);
		if (invoiceDTO.getProvider() != null) {
			invoice.setProvider(Provider.fromDTO(invoiceDTO.getProvider()));
		}
		List<InvoiceProductDTO> invoiceProductsDTO = invoiceDTO.getInvoiceProducts();
		if (invoiceProductsDTO != null) {
			List<InvoiceProduct> invoiceProducts = invoiceProductsDTO.parallelStream().map(InvoiceProduct::fromDTO).collect(Collectors.toList());
			invoice.setInvoiceProducts(invoiceProducts);
		}
		return invoice;
	}
	
}
