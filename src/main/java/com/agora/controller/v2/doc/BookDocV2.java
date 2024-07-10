package com.agora.controller.v2.doc;

import com.agora.dto.BookDto;
import com.agora.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "book" , description = "API for Book Management")
@RequestMapping("/v2/book")
public interface BookDocV2 {
    @Operation(summary = "Create book")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Book created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto);

    @Operation(summary = "Get all books")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping
    ResponseEntity<List<Book>> getAllBooks();

    @Operation(summary = "Get book by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/{id}")
    ResponseEntity<Book> getBookById(@PathVariable String id);

    @Operation(summary = "Update book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book updated", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PutMapping("/{id}")
    ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody @Valid BookDto bookDto);

    @Operation(summary = "Delete book")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Book deleted", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBook(@PathVariable String id);

    @Operation(summary = "Get book by title")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/title/{title}")
    ResponseEntity<Book> getBookByTitle(@PathVariable String title);

    @Operation(summary = "Get books by title containing")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Books not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/titleContaining/{title}")
    ResponseEntity<List<Book>> getBooksByTitleContaining(@PathVariable String title);

    @Operation(summary = "Get books by author")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Books not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/author/{author}")
    ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author);

    @Operation(summary = "Get books by genre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Books not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/genre/{genre}")
    ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre);

    @Operation(summary = "Get books by publication date")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Books not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/published/{published}")
    ResponseEntity<List<Book>> getBooksByPublicationDate(@PathVariable LocalDate published);

    @Operation(summary = "Get books by publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Books not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/publisher/{publisher}")
    ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable String publisher);
}
