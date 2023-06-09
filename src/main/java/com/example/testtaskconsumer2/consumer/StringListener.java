package com.example.testtaskconsumer2.consumer;


import com.example.testtaskconsumer2.EnrichedStringsService;
import com.example.testtaskconsumer2.dto.StringDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class StringListener {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private final LocalDateTime startDateTime = LocalDateTime.now();

    private final EnrichedStringsService enrichedStringsService;

    @KafkaListener(topics = "${kafka-topic.strings-under-100}", groupId = "Some_group")
    public void srtringResolver(StringDto stringDto) {
        log.debug("Received string: {}", stringDto);
        var result = enrichedStringsService.saveEnrichedString(stringDto.getWord());
        log.debug("String saved: {}", result);
        log.info("PROFILER: Enriced messaging: {}, count: {}", ChronoUnit.SECONDS.between(startDateTime, LocalDateTime.now()), atomicInteger.incrementAndGet());
    }

}
