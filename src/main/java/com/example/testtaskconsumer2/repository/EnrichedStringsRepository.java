package com.example.testtaskconsumer2.repository;

import com.example.testtaskconsumer2.entity.EnrichedStrings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface EnrichedStringsRepository extends JpaRepository<EnrichedStrings, UUID> {

}