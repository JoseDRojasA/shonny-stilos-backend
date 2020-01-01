package com.shonny.backend.repository;
import com.shonny.backend.entity.Product;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
	List<Product> findAllByActive(final Boolean active, Sort sort);
}
