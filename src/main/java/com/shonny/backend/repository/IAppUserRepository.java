package com.shonny.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shonny.backend.entity.AppUser;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

	Optional<AppUser> findByUsername(String username);

	Optional<AppUser> findByPersonEmail(String email);

	Optional<AppUser> findByUsernameIgnoreCase(String username);

}
