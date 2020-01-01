package com.shonny.backend.entity;

import java.io.Serializable;
import java.util.List;

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

import org.springframework.beans.BeanUtils;

import com.shonny.backend.model.ProductDTO;

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "SELECT a FROM Product a")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_product")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name="buy_price", nullable = false)
	private Long buyPrice;
	
	@Column(nullable = false)
	private Long price;
	
	@Column(nullable = false)
	private Integer amount;
	
	@Column(name="min_amount", nullable = false)
	private Integer minAmount;
	
	@Column(nullable = false)
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_brand", nullable = false)
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id_provider", nullable = false)
	private Provider provider;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<InvoiceProduct> invoiceProducts;

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

	public List<InvoiceProduct> getInvoiceProducts() {
		return invoiceProducts;
	}

	public void setInvoiceProducts(List<InvoiceProduct> invoiceProducts) {
		this.invoiceProducts = invoiceProducts;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public ProductDTO toDTO() {
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(this, productDTO);
		if (brand != null) {
			productDTO.setBrand(brand.toDTO());
		}
		if (provider != null) {
			productDTO.setProvider(provider.toDTO());
		}
		return productDTO;
	}
	
	public static Product fromDTO(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		if (productDTO.getBrand() != null) {
			Brand brand = new Brand();
			BeanUtils.copyProperties(productDTO.getBrand(), brand);
			product.setBrand(brand);
		}
		if (productDTO.getProvider() != null) {
			Provider provider = new Provider();
			BeanUtils.copyProperties(productDTO.getProvider(), provider);
			product.setProvider(provider);
		}
		return product;
	}
}

