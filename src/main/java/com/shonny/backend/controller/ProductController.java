package com.shonny.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shonny.backend.model.ProductDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.IProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductService service;
	
	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> findProducts() {
		return new ResponseEntity<List<ProductDTO>>(service.findProducts(), HttpStatus.OK);
	}
	
	@GetMapping(path="/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> findProductsActive() {
		return new ResponseEntity<List<ProductDTO>>(service.findProductsActive(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> findProductById(@PathVariable final Long id) {
		return new ResponseEntity<>(service.findProductById(id), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody final ProductDTO product) throws Exception {
		return new ResponseEntity<>(service.saveProduct(product), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable final Long id) {
		service.deleteProduct(id);
		ResponseDTO response = new ResponseDTO();
		response.setSucessful(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
