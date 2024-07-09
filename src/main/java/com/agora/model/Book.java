package com.agora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    private String id;

    private String title;

    private String author;

    private String edition;

    private String isbn;

    private String publisher;

    private int pages;

    private LocalDate published;

    private String genre;
}
