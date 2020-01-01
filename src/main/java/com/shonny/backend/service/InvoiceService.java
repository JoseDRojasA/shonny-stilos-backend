package com.shonny.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.shonny.backend.entity.Invoice;
import com.shonny.backend.entity.InvoiceProductKey;
import com.shonny.backend.model.InvoiceDTO;
import com.shonny.backend.repository.IInvoiceProductRepository;
import com.shonny.backend.repository.IInvoiceRepository;

@Service
public class InvoiceService implements IInvoiceService {
	
	@Autowired
	private IInvoiceRepository repository;
	
	@Autowired
	private IInvoiceProductRepository invoiceProductRepository;

	@Override
	public List<InvoiceDTO> findInvoices(String sort, String order, Integer pageSize, Integer page, String search) {
		List<Invoice> invoices;

		if (sort == null) {
			Sort sortBy = Sort.by("date").descending();
			invoices = StreamSupport.stream(repository.findAll(sortBy).spliterator(), false)
				    .collect(Collectors.toList());
		} else {
			Sort sortBy = Sort.by(sort).descending();
			if ("1".equals(order)) {
				sortBy = sortBy.ascending();
			}
			Pageable pageable = PageRequest.of(page - 1, pageSize, sortBy);

			if (StringUtils.isEmpty(search)) {
				invoices= repository.findAll(pageable).toList();
			} else {
				invoices = repository.findAllBySearch(search, pageable).toList();
			}
		}

		return invoices.parallelStream().map(Invoice::toDTO).collect(Collectors.toList());
	}

	@Override
	public InvoiceDTO findInvoiceById(Long id) {
		Invoice invoice = repository.findById(id).orElse(null);
		if (invoice == null) {
			return null;
		}
		InvoiceDTO invoiceDTO = invoice.toDTO();
		return invoiceDTO;
	}
	
	@Override
	@Transactional
	public void deleteInvoice(Long id) {
		deleteInvoiceInventory(id);
		repository.deleteInvoice(id);
	}
	
	@Transactional
	public void deleteInvoiceInventory(Long id) {
		repository.removeInvoiceProductsInventory(id);
		repository.deleteInvoiceProducts(id);
	}
	
	@Override
	@Transactional
	public InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO) throws Exception {
		if (invoiceDTO.getId() != null) {
			deleteInvoiceInventory(invoiceDTO.getId());
		}
		Invoice invoice = Invoice.fromDTO(invoiceDTO);
		repository.save(invoice);
		invoice.getInvoiceProducts().parallelStream().forEach(invoiceProducts -> {
			if (invoiceProducts.getId() == null) {
				invoiceProducts.setId(new InvoiceProductKey());
				invoiceProducts.getId().setInvoice(invoice.getId());
				invoiceProducts.getId().setProduct(invoiceProducts.getProduct().getId());
			}
			invoiceProductRepository.save(invoiceProducts);
		});
		repository.addInvoiceProductsInventory(invoice.getId());
		return invoice.toDTO();
	}
}
