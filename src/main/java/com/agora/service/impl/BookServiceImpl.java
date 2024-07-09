package com.agora.service.impl;

import com.agora.dto.BookDto;
import com.agora.exception.MyHandleException;
import com.agora.model.Book;
import com.agora.repository.IBookRepository;
import com.agora.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepository iBookRepository;

    @Override
    public ResponseEntity<Book> create(BookDto bookDto) {
        String uuid = UUID.randomUUID().toString();
        Book book = Book
                .builder()
                .id(uuid)
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .edition(bookDto.getEdition())
                .isbn(bookDto.getIsbn())
                .publisher(bookDto.getPublisher())
                .pages(bookDto.getPages())
                .published(bookDto.getPublished())
                .genre(bookDto.getGenre())
                .build();

        var newBook = this.iBookRepository.save(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newBook);

    }

    @Override
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity
                .ok(this.iBookRepository.findAll());
    }

    @Override
    public ResponseEntity<Book> findById(String id) {
        return iBookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new MyHandleException("No book found with the ID: " + id));
    }

    @Override
    public ResponseEntity<Book> update(String id, BookDto bookDto) {

        return iBookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(bookDto.getTitle());
                    existingBook.setAuthor(bookDto.getAuthor());
                    existingBook.setEdition(bookDto.getEdition());
                    existingBook.setIsbn(bookDto.getIsbn());
                    existingBook.setPublisher(bookDto.getPublisher());
                    existingBook.setPages(bookDto.getPages());
                    existingBook.setPublished(bookDto.getPublished());
                    existingBook.setGenre(bookDto.getGenre());

                    Book updatedBook = iBookRepository.save(existingBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElseThrow(() -> new MyHandleException("No book found with the ID: " + id));
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return iBookRepository.findById(id)
                .map(book -> {
                    iBookRepository.delete(book);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseThrow(() -> new MyHandleException("No book found with the ID: " + id));
    }

    @Override
    public ResponseEntity<Book> findByTitle(String title) {
        return iBookRepository.findBookByTitle(title)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new MyHandleException("No book found with the title: " + title));
    }

    @Override
    public ResponseEntity<List<Book>> findByTitleContaining(String title) {
        List<Book> books = iBookRepository.findBookByTitleContaining(title);
        if(!books.isEmpty()) {
            return ResponseEntity.ok(books);
        }else{
            throw new MyHandleException("No books found for the title containing: " + title);
        }
    }

    @Override
    public ResponseEntity<List<Book>> findByAuthor(String author) {
        List<Book> books = iBookRepository.findBookByAuthorContaining(author);
        if(!books.isEmpty()) {
            return ResponseEntity.ok(books);
        }else{
            throw new MyHandleException("No books found for the author: " + author);
        }
    }

    @Override
    public ResponseEntity<List<Book>> findByGenre(String genre) {
        List<Book> books = iBookRepository.findBookByGenre(genre);
        if(!books.isEmpty()) {
            return ResponseEntity.ok(books);
        }else{
            throw new MyHandleException("No books found for the genre: " + genre);
        }

    }

    @Override
    public ResponseEntity<List<Book>> findByPublicationDate(LocalDate published) {
        List<Book> books = iBookRepository.findBookByPublished(published);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            throw new MyHandleException("No books found for the publication date: " + published);
        }
    }

    @Override
    public ResponseEntity<List<Book>> findByPublisher(String publisher) {
        List<Book> books = iBookRepository.findBookByPublisher(publisher);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            throw new MyHandleException("No books found for the publisher: " + publisher);
        }
    }
}
