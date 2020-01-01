package com.shonny.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.shonny.backend.entity.Brand;

public interface IBrandRepository extends PagingAndSortingRepository<Brand, Integer> {
	List<Brand> findAllByNameIgnoreCase(final String name, Pageable pageable);
}
