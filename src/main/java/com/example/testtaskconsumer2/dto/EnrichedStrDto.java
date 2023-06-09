package com.example.testtaskconsumer2.dto;

import com.example.testtaskconsumer2.entity.EnrichedStrings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class EnrichedStrDto implements Serializable {

    private UUID id;

    private String value;

    private Instant createDate;

    public static EnrichedStrDto fromEntity(EnrichedStrings enrichedStrings) {
        return new EnrichedStrDto(enrichedStrings.getId(), enrichedStrings.getValue(), enrichedStrings.getCreateDate());
    }

}
