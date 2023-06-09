package com.example.testtaskconsumer2.repository;

import com.example.testtaskconsumer2.entity.EnrichedStrings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnrichedStringsRepository extends JpaRepository<EnrichedStrings, String>, JpaSpecificationExecutor<EnrichedStrings> {

}