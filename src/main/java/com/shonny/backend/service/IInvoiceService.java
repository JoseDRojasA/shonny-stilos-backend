package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.InvoiceDTO;

public interface IInvoiceService {

	public List<InvoiceDTO> findInvoice(String sort, String order, Integer pageSize, Integer page, String search);

	public InvoiceDTO findInvoiceById(Integer id);

	public void deleteInvoice(Integer id);

	public InvoiceDTO saveInvoice(InvoiceDTO invoice);
}
