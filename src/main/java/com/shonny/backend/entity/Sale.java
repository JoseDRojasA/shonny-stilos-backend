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

import com.shonny.backend.model.SaleDTO;
import com.shonny.backend.model.SaleProductDTO;

@Entity
@Table(name = "sale")
@NamedQuery(name = "Sale.findAll", query = "SELECT a FROM Sale a")
public class Sale implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sale")
	private Long id;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH}, mappedBy = "sale")
	private List<SaleProduct> saleProducts;
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(List<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SaleDTO toDTO() {
		SaleDTO saleDTO = new SaleDTO();
		BeanUtils.copyProperties(this, saleDTO);
		if (client != null) {
			saleDTO.setClient(client.toDTO());
		}
		if (saleProducts != null) {
			List<SaleProductDTO> saleProducts = getSaleProducts()
					.parallelStream()
					.map(SaleProduct::toDTO)
					.collect(Collectors.toList());
			saleDTO.setSaleProducts(saleProducts);
		}
		return saleDTO;
	}

	public static Sale fromDTO(SaleDTO saleDTO) {
		Sale sale = new Sale();
		BeanUtils.copyProperties(saleDTO, sale);
		if (saleDTO.getClient() != null) {
			sale.setClient(Client.fromDTO(saleDTO.getClient()));
		}
		if (saleDTO.getSaleProducts() != null) {
			List<SaleProduct> saleProducts = saleDTO.getSaleProducts().parallelStream().map(SaleProduct::fromDTO).collect(Collectors.toList());
			sale.setSaleProducts(saleProducts);
		}
		return sale;
	}
	
}
