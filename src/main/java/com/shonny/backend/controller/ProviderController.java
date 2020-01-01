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

import com.shonny.backend.model.ProviderDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.IProviderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/providers")
public class ProviderController {

	@Autowired
	private IProviderService service;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProviderDTO> findProviderById(@PathVariable final Long id) {
		return new ResponseEntity<>(service.findProviderById(id), HttpStatus.OK);
	}

	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProviderDTO>> findProviders() {
		return new ResponseEntity<List<ProviderDTO>>(service.findProviders(), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProviderDTO> saveProvider(@RequestBody final ProviderDTO provider) throws Exception {
		return new ResponseEntity<>(service.saveProvider(provider), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> deleteProvider(@PathVariable final Long id) {
		service.deleteProvider(id);
		ResponseDTO response = new ResponseDTO();
		response.setSucessful(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
