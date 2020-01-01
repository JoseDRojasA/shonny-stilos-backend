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

import com.shonny.backend.model.InvoiceDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.IInvoiceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private IInvoiceService service;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceDTO> findInvoiceById(@PathVariable final Long id) {
		InvoiceDTO invoiceDTO = service.findInvoiceById(id);
		return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
	}

	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InvoiceDTO>> findInvoices(
			@RequestParam(required = false) final String sort,
			@RequestParam(required = false) final String order, 
			@RequestParam(required = false) final Integer page, 
			@RequestParam(required = false) final Integer pageSize,
			@RequestParam(required = false) final String search) {
		return new ResponseEntity<List<InvoiceDTO>>(service.findInvoices(sort, order, pageSize, page, search), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceDTO> saveInvoice(@RequestBody final InvoiceDTO invoice) throws Exception {
		return new ResponseEntity<>(service.saveInvoice(invoice), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> deleteInvoice(@PathVariable final Long id) {
		service.deleteInvoice(id);
		ResponseDTO response = new ResponseDTO();
		response.setSucessful(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
