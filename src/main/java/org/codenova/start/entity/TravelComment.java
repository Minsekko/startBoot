package org.codenova.start.entity;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelComment {
    private int id;
    private String isoCode;
    private String body;
    private LocalDate writedAt;
}
