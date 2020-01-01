package com.shonny.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shonny.backend.entity.Sale;

public interface ISaleRepository extends PagingAndSortingRepository<Sale, Long>, JpaRepository<Sale, Long> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET amount = amount + COALESCE((SELECT amount FROM sale_product WHERE sale_product.id_product=product.id_product AND sale_product.id_sale = :idSale),0)", 
			  nativeQuery = true
			  )
	public void removeSaleProductsInventory(@Param("idSale") final Long idSale);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET amount = amount - COALESCE((SELECT amount FROM sale_product WHERE sale_product.id_product=product.id_product AND sale_product.id_sale = :idSale),0)", 
			  nativeQuery = true)
	public void addSaleProductsInventory(@Param("idSale") final Long idSale);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM sale_product WHERE id_sale = :idSale", 
			  nativeQuery = true
			  )
	public void deleteSaleProducts(@Param("idSale") final Long idSale);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM sale WHERE id_sale = :idSale", 
			  nativeQuery = true
			  )
	public void deleteSale(@Param("idSale") final Long idSale);
	
	@Query(value = "SELECT * FROM sale WHERE CAST ( date as VARCHAR ) LIKE %:search% OR clientName LIKE %:search% ", 
			countQuery = "SELECT count(*) FROM sale WHERE CAST ( date as VARCHAR ) LIKE %:search% OR clientName LIKE %:search% ",
			  nativeQuery = true
			  )
	public Page<Sale> findAllBySearch(@Param("search") final String search, final Pageable pageable);
}
