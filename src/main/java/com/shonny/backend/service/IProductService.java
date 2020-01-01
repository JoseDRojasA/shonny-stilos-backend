package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.ProductDTO;

public interface IProductService {
	public List<ProductDTO> findProducts();
	
	public List<ProductDTO> findProductsActive();

	public ProductDTO findProductById(Long id);

	public void deleteProduct(Long id);

	public ProductDTO saveProduct(ProductDTO productDTO) throws Exception;
}
