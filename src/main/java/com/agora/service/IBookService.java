package com.agora.service;

import com.agora.dto.BookDto;
import com.agora.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookService {
    ResponseEntity<Book> save (BookDto bookDto);
    ResponseEntity<List<Book>> findAll();
    ResponseEntity<Book> findById(String id);
    ResponseEntity<Book> update(String id, BookDto bookDto);
    ResponseEntity<Void> deleteById(String id);
    ResponseEntity<List<Book>> findByTitle(String title);
    ResponseEntity<List<Book>> findByAuthor(String author);
    ResponseEntity<List<Book>> findByGenre(String genre);
    ResponseEntity<List<Book>> findByPublicationDate(String published);
    ResponseEntity<List<Book>> findByPublisher(String publisher);
}
