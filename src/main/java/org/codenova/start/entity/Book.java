package org.codenova.start.entity;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String author;
    private String title;
    private String publisher;
    private LocalDate publishedAt;
}
