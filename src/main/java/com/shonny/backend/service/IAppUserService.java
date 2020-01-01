package com.shonny.backend.service;

import com.shonny.backend.entity.AppUser;
import com.shonny.backend.model.AppUserDTO;
import com.shonny.backend.model.AppUserPassDTO;
import com.shonny.backend.model.ResponseDTO;

public interface IAppUserService {
	AppUserDTO registerUser(AppUser user) throws Exception;

	AppUserDTO editUser(AppUser user, Integer userId) throws Exception;

	ResponseDTO changePass(AppUserPassDTO passDTO, Integer userId) throws Exception;

	AppUserDTO authenticateUser(AppUser user) throws Exception;
}
