package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private InvoiceRepository invoiceRepository;


    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity entity = invoiceMapper.toEntity(invoiceDTO);
        entity = invoiceRepository.save(entity);

        return invoiceMapper.toDTO(entity);
    }

    public List<InvoiceDTO> getIsuedInvoices(){
        return invoiceRepository.findByIsIssuedTrue()
                .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<InvoiceDTO> getReceivedInvoices() {
        return invoiceRepository.findByIsIssuedFalse()
                .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> getAll() {
        return invoiceRepository.findByHidden(false)
                .stream()
                .map(i -> invoiceMapper.toDTO(i))
                .collect(Collectors.toList());
    }


}
