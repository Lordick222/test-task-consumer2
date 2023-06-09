package com.example.testtaskconsumer2.consumer;


import com.example.testtaskconsumer2.EnrichedStringsService;
import com.example.testtaskconsumer2.dto.StringDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@RequiredArgsConstructor
@Slf4j
public class StringListener {

    private final EnrichedStringsService enrichedStringsService;

    @KafkaListener(topics = "${kafka-topic.strings-under-100}", groupId = "Some group")
    public void entitiesDiffListener(StringDto stringDto) {
        log.debug("Received string: {}", stringDto);
        var result = enrichedStringsService.saveEnrichedString(stringDto.getWord());
        log.debug("String saved: {}", result);
    }

}
