package com.shonny.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shonny.backend.entity.Invoice;

public interface IInvoiceRepository extends PagingAndSortingRepository<Invoice, Long>, JpaRepository<Invoice, Long> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET amount = amount - COALESCE((SELECT amount FROM invoice_product WHERE invoice_product.id_product=product.id_product AND invoice_product.id_invoice = :idInvoice),0)", 
			  nativeQuery = true
			  )
	public void removeInvoiceProductsInventory(@Param("idInvoice") final Long idInvoice);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET amount = amount + COALESCE((SELECT amount FROM invoice_product WHERE invoice_product.id_product=product.id_product AND invoice_product.id_invoice = :idInvoice),0)", 
			  nativeQuery = true)
	public void addInvoiceProductsInventory(@Param("idInvoice") final Long idInvoice);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM invoice_product WHERE id_invoice = :idInvoice", 
			  nativeQuery = true
			  )
	public void deleteInvoiceProducts(@Param("idInvoice") final Long idInvoice);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM invoice WHERE id_invoice = :idInvoice", 
			  nativeQuery = true
			  )
	public void deleteInvoice(@Param("idInvoice") final Long idInvoice);
	
	@Query(value = "SELECT * FROM invoice WHERE CAST ( date as VARCHAR ) LIKE %:search% OR serial LIKE %:search% OR id_provider IN (SELECT id_provider FROM provider WHERE name LIKE %:search%) ", 
			countQuery = "SELECT * FROM invoice WHERE CAST ( date as VARCHAR ) LIKE %:search% OR serial LIKE %:search% OR id_provider IN (SELECT id_provider FROM provider WHERE name LIKE %:search%)",
			  nativeQuery = true
			  )
	public Page<Invoice> findAllBySearch(@Param("search") final String search, final Pageable pageable);
}
