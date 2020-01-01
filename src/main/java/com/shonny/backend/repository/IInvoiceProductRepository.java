package com.shonny.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.shonny.backend.entity.InvoiceProduct;
import com.shonny.backend.entity.InvoiceProductKey;

public interface IInvoiceProductRepository extends CrudRepository<InvoiceProduct, InvoiceProductKey> {

}
