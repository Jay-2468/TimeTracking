package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer>{

}
