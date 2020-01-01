package com.shonny.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shonny.backend.entity.Provider;

public interface IProviderRepository extends PagingAndSortingRepository<Provider, Long> {

}
