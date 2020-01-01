package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.InvoiceDTO;

public interface IInvoiceService {

	public List<InvoiceDTO> findInvoices(String sort, String order, Integer pageSize, Integer page, String search);

	public InvoiceDTO findInvoiceById(Long id);

	public void deleteInvoice(Long id);

	public InvoiceDTO saveInvoice(InvoiceDTO invoice) throws Exception;
}
