package com.shonny.backend.service;

import com.shonny.backend.model.InvoiceDTO;
import com.shonny.backend.model.PaginationDTO;

public interface IInvoiceService {

	public PaginationDTO findInvoices(String sort, String order, Integer pageSize, Integer page, String search);

	public InvoiceDTO findInvoiceById(Long id);

	public void deleteInvoice(Long id);

	public InvoiceDTO saveInvoice(InvoiceDTO invoice) throws Exception;
}
