package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.entity.InvoiceEntity;

import java.util.List;


public interface InvoiceService {


    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    List<InvoiceDTO> getAll();

    List<InvoiceDTO> getIsuedInvoices();

    List<InvoiceDTO> getReceivedInvoices();
}
