package com.shonny.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shonny.backend.entity.Invoice;
import com.shonny.backend.model.InvoiceDTO;
import com.shonny.backend.repository.IInvoiceRepository;

@Service
public class InvoiceService implements IInvoiceService {
	
	@Autowired
	private IInvoiceRepository repository;

	@Override
	public List<InvoiceDTO> findInvoice(String sort, String order, Integer pageSize, Integer page, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDTO findInvoiceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInvoice(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public InvoiceDTO saveInvoice(InvoiceDTO invoiceDTO) {
		Invoice invoice = Invoice.fromDTO(invoiceDTO);
		repository.save(invoice);
		return invoice.toDTO();
	}

}
