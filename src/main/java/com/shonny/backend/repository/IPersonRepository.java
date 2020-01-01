package com.shonny.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shonny.backend.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, String> {

}
