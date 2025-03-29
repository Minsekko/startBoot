package org.codenova.start.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelComment {
    private int id;
    private String isoCode;
    private String body;
    private LocalDateTime writedAt;
}
