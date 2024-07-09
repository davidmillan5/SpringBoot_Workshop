package com.agora.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 1, message = "Pages must be greater than zero")
    private int pages;
    @NotNull(message = "Published date must not be null")
    private LocalDate published;
    @NotBlank(message = "Category is mandatory")
    private String genre;
}
