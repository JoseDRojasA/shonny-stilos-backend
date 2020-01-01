package com.shonny.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shonny.backend.entity.Invoice;

public interface IInvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {

}
