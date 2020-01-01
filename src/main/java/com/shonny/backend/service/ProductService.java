package com.shonny.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shonny.backend.entity.Product;
import com.shonny.backend.model.ProductDTO;
import com.shonny.backend.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository repository;

	@Override
	public List<ProductDTO> findProducts() {
		Sort sortBy = Sort.by("name").ascending();
		List<Product> providers = StreamSupport.stream(repository.findAll(sortBy).spliterator(), false)
			    .collect(Collectors.toList());
		return providers.parallelStream().map(Product::toDTO).collect(Collectors.toList());	
	}

	@Override
	public List<ProductDTO> findProductsActive() {
		Sort sortBy = Sort.by("name").ascending();
		List<Product> providers = StreamSupport.stream(repository.findAllByActive(true, sortBy).spliterator(), false)
			    .collect(Collectors.toList());
		return providers.parallelStream().map(Product::toDTO).collect(Collectors.toList());	
	}

	@Override
	public ProductDTO findProductById(Long id) {
		Product provider = repository.findById(id).orElse(null);
		if (provider == null) {
			return null;
		}
		return provider.toDTO();
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		Product product = new Product();
		product.setId(id);
		repository.delete(product);
	}

	@Override
	@Transactional
	public ProductDTO saveProduct(ProductDTO productDTO) throws Exception {
		if (productDTO.getPrice() < productDTO.getBuyPrice()) {
			throw new Exception("El precio de venta no puede ser menor al precio de compra");
		}
		Product product = Product.fromDTO(productDTO);
		repository.save(product);
		return product.toDTO();
	}

}
