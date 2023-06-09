package com.example.testtaskconsumer2;

import com.example.testtaskconsumer2.dto.EnrichedStrDto;
import com.example.testtaskconsumer2.entity.EnrichedStrings;
import com.example.testtaskconsumer2.repository.EnrichedStringsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
@Slf4j
public class EnrichedStringsService {

    private final EnrichedStringsRepository enrichedStringsRepository;

    public EnrichedStrDto saveEnrichedString(String str) {
        var entity = new EnrichedStrings(str, Instant.now());
        var result = enrichedStringsRepository.save(entity);
        log.info("Enriched string saved: {}", result);
        return EnrichedStrDto.fromEntity(result);
    }

}
