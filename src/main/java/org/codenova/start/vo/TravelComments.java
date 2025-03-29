package org.codenova.start.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Builder
public class TravelComments {
    private int id;
    private String isoCode;
    private String body;
    private LocalDate writedAt;
    private String time;
}
