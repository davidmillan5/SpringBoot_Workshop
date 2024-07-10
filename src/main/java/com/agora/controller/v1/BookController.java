package com.agora.controller.v1;

import com.agora.dto.BookDto;
import com.agora.model.Book;
import com.agora.service.IBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/book")
public class BookController {

    private final IBookService iBookService;


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto){
        return iBookService.create(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return iBookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return iBookService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody @Valid BookDto bookDto) {
        return iBookService.update(id, bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        return iBookService.delete(id);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return iBookService.findByTitle(title);
    }

    @GetMapping("/titleContaining/{title}")
    public ResponseEntity<List<Book>> getBooksByTitleContaining(@PathVariable String title) {
        return iBookService.findByTitleContaining(title);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        return iBookService.findByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        return iBookService.findByGenre(genre);
    }

    @GetMapping("/published/{published}")
    public ResponseEntity<List<Book>> getBooksByPublicationDate(@PathVariable LocalDate published) {
        return iBookService.findByPublicationDate(published);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable String publisher) {
        return iBookService.findByPublisher(publisher);
    }



}
