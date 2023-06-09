package com.example.testtaskconsumer2.consumer;


import com.example.testtaskconsumer2.EnrichedStringsService;
import com.example.testtaskconsumer2.dto.StringDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StringListener {

    private final EnrichedStringsService enrichedStringsService;

    @KafkaListener(topics = "${kafka-topic.strings-under-100}", groupId = "Some_group")
    public void srtringResolver(StringDto stringDto) {
        log.debug("Received string: {}", stringDto);
        var result = enrichedStringsService.saveEnrichedString(stringDto.getWord());
        log.debug("String saved: {}", result);
    }

}
