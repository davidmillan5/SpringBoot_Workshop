package com.agora.repository;

import com.agora.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface IBookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByTitle(String title);
    List<Book> findBookByGenre(String genre);
    List<Book> findBookByPublisher(String publisher);
    List<Book> findBookByPublished(LocalDate published);
    List<Book> findBookByTitleContaining(String title);
    List<Book> findBookByAuthorContaining(String author);
}
