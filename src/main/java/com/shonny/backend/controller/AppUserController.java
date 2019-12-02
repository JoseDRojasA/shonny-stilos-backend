package com.shonny.backend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shonny.backend.entity.AppUser;
import com.shonny.backend.model.AppUserDTO;
import com.shonny.backend.model.AppUserPassDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.service.IAppUserService;
import com.shonny.backend.utils.EmailUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class AppUserController {
	@Autowired
	private IAppUserService service;
	
	private static final String USERNAME_REQUIRED = "Username requerido.";
	private static final String PASSWORD_REQUIRED = "Contraseña requerida.";
	private static final String EMAIL_REQUIRED = "Correo requerido.";
	private static final String NAME_REQUIRED = "Nombre requerido.";
	private static final String PERSON_REQUIRED = "Información personal requerida.";
	
	private static final String INVALID_EMAIL = "Correo invalido.";
	
	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUserDTO> register(@RequestBody final AppUserDTO userDTO, HttpSession session) throws Exception {
		Assert.hasText(userDTO.getUsername(), USERNAME_REQUIRED);
		Assert.hasText(userDTO.getPassword(), PASSWORD_REQUIRED);
		Assert.notNull(userDTO.getPerson(), PERSON_REQUIRED);
		Assert.hasText(userDTO.getPerson().getEmail(), EMAIL_REQUIRED);
		Assert.hasText(userDTO.getPerson().getName(), NAME_REQUIRED);
		Assert.isTrue(EmailUtils.emailValid(userDTO.getPerson().getEmail()), INVALID_EMAIL);

		return new ResponseEntity<>(service.registerUser(AppUser.fromDTO(userDTO), session.getId()), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/user/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUserDTO> edit(@RequestBody final AppUserDTO userDTO, @PathVariable final int idUser) throws Exception {
		Assert.hasText(userDTO.getUsername(), USERNAME_REQUIRED);
		Assert.notNull(userDTO.getPerson(), PERSON_REQUIRED);
		Assert.hasText(userDTO.getPerson().getEmail(), EMAIL_REQUIRED);
		Assert.hasText(userDTO.getPerson().getName(), NAME_REQUIRED);
		Assert.isTrue(EmailUtils.emailValid(userDTO.getPerson().getEmail()), INVALID_EMAIL);
		
		return new ResponseEntity<>(service.editUser(userDTO.toEntity(), idUser), HttpStatus.OK);
	}
	
	@PutMapping(path = "/password/{idUser}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> changePass(@RequestBody final AppUserPassDTO passDTO,
			@PathVariable final int idUser) throws Exception {
		Assert.hasText(passDTO.getOldPass(), PASSWORD_REQUIRED);
		Assert.hasText(passDTO.getNewPass(), NAME_REQUIRED);

		return new ResponseEntity<>(service.changePass(passDTO, idUser), HttpStatus.OK);
	}
	
	@PostMapping(path = "/authentication", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AppUserDTO> authenticate(@RequestBody final AppUserDTO userDTO, HttpSession session) throws Exception {
		Assert.hasText(userDTO.getUsername(), USERNAME_REQUIRED);
		Assert.hasText(userDTO.getPassword(), PASSWORD_REQUIRED);
		return new ResponseEntity<>(service.authenticateUser(userDTO.toEntity()), HttpStatus.ACCEPTED);
	}
}
