package com.shonny.backend.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shonny.backend.model.BrandDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.IBrandService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private IBrandService service;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandDTO> findBrandById(@PathVariable final Integer id) {
		return new ResponseEntity<>(service.findBrandById(id), HttpStatus.OK);
	}

	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BrandDTO>> findBrands(
			@RequestParam(required = false) final String sort,
			@RequestParam(required = false) final String order, 
			@RequestParam(required = false) final Integer page, 
			@RequestParam(required = false) final Integer pageSize,
			@RequestParam(required = false) final String search) {
		return new ResponseEntity<>(service.findBrands(sort, order, pageSize, page, search), HttpStatus.OK);
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BrandDTO> saveBrand(@RequestBody final BrandDTO brand) throws Exception {
		return new ResponseEntity<>(service.saveBrand(brand), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> deleteBrand(@PathVariable final Integer id) {
		service.deleteBrand(id);
		ResponseDTO response = new ResponseDTO();
		response.setSucessful(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
