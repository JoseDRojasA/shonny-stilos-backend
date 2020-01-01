package com.shonny.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.shonny.backend.entity.AppUser;
import com.shonny.backend.model.AppUserDTO;
import com.shonny.backend.model.AppUserPassDTO;
import com.shonny.backend.model.ResponseDTO;
import com.shonny.backend.repository.IAppUserRepository;
import com.shonny.backend.repository.IPersonRepository;
import com.shonny.backend.utils.Utils;

@Service
public class AppUserService implements IAppUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private IAppUserRepository repository;
	
	@Autowired
	private IPersonRepository personRepository;
	
	@Override
	@Transactional
	public AppUserDTO registerUser(AppUser user) throws Exception {
		try {
			user.setPassword(Utils.hashPassword(user.getPassword()));
			personRepository.saveAndFlush(user.getPerson());
			repository.save(user);
			AppUserDTO response = user.toDTO();
			return response;
		} catch (final Exception e) {
			LOGGER.error("El usuario no pudo ser registrado.", e);
			throw new Exception("El usuario no pudo ser registrado: " + e.getMessage(), e);
		}

	}

	@Override
	@Transactional
	public AppUserDTO editUser(AppUser user, Integer userId) throws Exception {
		try {
			final AppUser foundUser = repository.findById(userId).orElse(null);
			if (foundUser == null) {
				throw new Exception("Usuario no encontrado.");
			}
			BeanUtils.copyProperties(foundUser, user);
			if (!StringUtils.isEmpty(user.getPassword())) {
				foundUser.setPassword(Utils.hashPassword(user.getPassword()));
			}
			repository.save(foundUser);
			return foundUser.toDTO();
		} catch (final Exception e) {
			LOGGER.error("El usuario no pudo ser editado.", e);
			throw new Exception("El usuario no pudo ser editado: " + e.getMessage(), e);
		}

	}

	@Override
	public AppUserDTO authenticateUser(final AppUser user) throws Exception {
		final AppUser foundUser = repository.findByUsernameIgnoreCase(user.getUsername())
				.orElseThrow(() -> new Exception("El nombre de usuario o contraseña son incorrectos."));
		
		if (!Utils.passwordsMatch(user.getPassword(), foundUser.getPassword())) {
			throw new Exception("El nombre de usuario o contraseña son incorrectos.");
		}

		return foundUser.toDTO();
	}
	
	@Override
	@Transactional
	public ResponseDTO changePass(final AppUserPassDTO passDTO, final Integer userId) throws Exception {
		try {
			final AppUser user = repository.findById(userId)
					.orElseThrow(() -> new Exception("Usuario no encontrado."));

			if (!Utils.passwordsMatch(passDTO.getOldPass(), user.getPassword())) {
				LOGGER.error("La contraseña anterior no es correcta.");
				throw new Exception("La contraseña anterior no es correcta.");
			}

			user.setPassword(Utils.hashPassword(passDTO.getNewPass()));
			repository.save(user);
			return new ResponseDTO("Contraseña cambiada exitosamente.", true);
		} catch (Exception e) {
			LOGGER.error("La contraseña no pudo ser cambiada.", e);
			throw new Exception("La contraseña no pudo ser cambiada: " + e.getMessage(), e);
		}
	}

}
