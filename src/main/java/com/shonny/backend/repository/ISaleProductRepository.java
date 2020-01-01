package com.shonny.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.shonny.backend.entity.SaleProduct;
import com.shonny.backend.entity.SaleProductKey;

public interface ISaleProductRepository extends CrudRepository<SaleProduct, SaleProductKey> {

}
