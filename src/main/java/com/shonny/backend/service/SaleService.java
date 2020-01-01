package com.shonny.backend.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.shonny.backend.entity.Sale;
import com.shonny.backend.entity.SaleProductKey;
import com.shonny.backend.model.PaginationDTO;
import com.shonny.backend.model.SaleDTO;
import com.shonny.backend.repository.ISaleProductRepository;
import com.shonny.backend.repository.ISaleRepository;

@Service
public class SaleService implements ISaleService {
	@Autowired
	private ISaleRepository repository;
	
	@Autowired
	private ISaleProductRepository saleProductRepository;
	
	@Override
	public PaginationDTO findSales(String sort, String order, Integer pageSize, Integer page, String search) {
		PaginationDTO pagination = new PaginationDTO();
		Page<Sale> invoices;
		Sort sortBy = Sort.by(sort).descending();
		if ("1".equals(order)) {
			sortBy = sortBy.ascending();
		}
		Pageable pageable = PageRequest.of(page - 1, pageSize, sortBy);

		if (StringUtils.isEmpty(search)) {
			invoices= repository.findAll(pageable);
		} else {
			invoices = repository.findAllBySearch(search, pageable);
		}
		pagination.setElements(invoices.toList().parallelStream().map(Sale::toDTO).collect(Collectors.toList()));
		pagination.setCount(invoices.getNumberOfElements());
		return pagination;
	}

	@Override
	public SaleDTO findSaleById(Long id) {
		Sale sale = repository.findById(id).orElse(null);
		if (sale == null) {
			return null;
		}
		SaleDTO saleDTO = sale.toDTO();
		return saleDTO;
	}

	@Override
	public void deleteSale(Long id) {
		deleteSaleInventory(id);
		repository.deleteSale(id);
	}
	
	@Transactional
	public void deleteSaleInventory(Long id) {
		repository.removeSaleProductsInventory(id);
		repository.deleteSaleProducts(id);
	}
	
	@Override
	public SaleDTO saveSale(SaleDTO saleDTO) throws Exception {
		if (saleDTO.getId() != null) {
			deleteSaleInventory(saleDTO.getId());
		}
		Sale sale = Sale.fromDTO(saleDTO);
		repository.save(sale);
		sale.getSaleProducts().parallelStream().forEach(saleProduct -> {
			if (saleProduct.getId() == null) {
				saleProduct.setId(new SaleProductKey());
				saleProduct.getId().setSale(sale.getId());
				saleProduct.getId().setProduct(saleProduct.getProduct().getId());
			}
			saleProductRepository.save(saleProduct);
		});
		repository.addSaleProductsInventory(sale.getId());
		return sale.toDTO();
	}

}
