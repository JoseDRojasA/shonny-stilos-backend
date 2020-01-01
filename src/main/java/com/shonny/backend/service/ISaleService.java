package com.shonny.backend.service;

import com.shonny.backend.model.SaleDTO;
import com.shonny.backend.model.PaginationDTO;

public interface ISaleService {

	public PaginationDTO findSales(String sort, String order, Integer pageSize, Integer page, String search);

	public SaleDTO findSaleById(Long id);

	public void deleteSale(Long id);

	public SaleDTO saveSale(SaleDTO saleDTO) throws Exception;
}
