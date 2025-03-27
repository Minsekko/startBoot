package org.codenova.start.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Movie {
    private int id;
    private String title;
    private String description;
    private String genre;
    private LocalDate releaseDate;
}
