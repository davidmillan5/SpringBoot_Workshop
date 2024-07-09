package com.agora.repository;

import com.agora.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, String> {
    List<Book> findBookByCategory(String genre);
    List<Book> finBookByPublisher(String publisher);
    List<Book> findBookByPublisherAndPublished(String publisher, LocalDate published);
    List<Book> findBookByTitleContaining(String title);
    List<Book> findBookByAuthorContaining(String author);
}
