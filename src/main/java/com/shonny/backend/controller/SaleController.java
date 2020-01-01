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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shonny.backend.model.SaleDTO;
import com.shonny.backend.model.PaginationDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.ISaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private ISaleService service;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SaleDTO> findSaleById(@PathVariable final Long id) {
		SaleDTO SaleDTO = service.findSaleById(id);
		return new ResponseEntity<>(SaleDTO, HttpStatus.OK);
	}

	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaginationDTO> findSales(
			@RequestParam(required = false) final String sort,
			@RequestParam(required = false) final String order, 
			@RequestParam(required = false) final Integer page, 
			@RequestParam(required = false) final Integer pageSize,
			@RequestParam(required = false) final String search) {
		return new ResponseEntity<PaginationDTO>(service.findSales(sort, order, pageSize, page, search), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SaleDTO> saveSale(@RequestBody final SaleDTO sale) throws Exception {
		return new ResponseEntity<>(service.saveSale(sale), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> deleteSale(@PathVariable final Long id) {
		service.deleteSale(id);
		ResponseDTO response = new ResponseDTO();
		response.setSucessful(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
