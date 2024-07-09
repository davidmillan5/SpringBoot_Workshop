package com.agora.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Author is mandatory")
    private String author;
    @NotBlank(message = "Edition is mandatory")
    private String edition;
    @NotBlank(message = "Isbn is mandatory")
    private String isbn;
    @NotBlank(message = "Publisher is mandatory")
    private String publisher;
    @NotBlank(message = "Pages are mandatory")
    private int pages;
    @NotBlank(message = "Date of Publishing is mandatory")
    private LocalDate published;
    @NotBlank(message = "Category is mandatory")
    private String genre;
}
