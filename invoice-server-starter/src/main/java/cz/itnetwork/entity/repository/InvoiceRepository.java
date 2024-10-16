package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByHidden(boolean hidden);

    List<InvoiceEntity> findByIsIssuedTrue();

    List<InvoiceEntity> findByIsIssuedFalse();
}
