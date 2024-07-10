package com.agora.controller.v2;

import com.agora.controller.v2.doc.BookDocV2;
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
@RequestMapping("/v2/book")
public class BookControllerV2 implements BookDocV2 {

    private final IBookService iBookService;

    @Override
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto) {
        return iBookService.create(bookDto);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return iBookService.findAll();
    }

    @Override
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return iBookService.findById(id);
    }

    @Override
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody @Valid BookDto bookDto) {
        return iBookService.update(id, bookDto);
    }

    @Override
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        return iBookService.delete(id);
    }

    @Override
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return iBookService.findByTitle(title);
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByTitleContaining(@PathVariable String title) {
        return iBookService.findByTitleContaining(title);
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        return iBookService.findByAuthor(author);
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        return iBookService.findByGenre(genre);
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByPublicationDate(@PathVariable LocalDate published) {
        return iBookService.findByPublicationDate(published);
    }

    @Override
    public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable String publisher) {
        return iBookService.findByPublisher(publisher);
    }
}
