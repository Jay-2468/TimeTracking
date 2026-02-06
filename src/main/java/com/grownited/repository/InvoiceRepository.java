package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

}
