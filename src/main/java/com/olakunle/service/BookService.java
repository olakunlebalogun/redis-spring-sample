package com.olakunle.service;

import com.olakunle.entity.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {

    ResponseEntity addBookToStore (Book book);

    ResponseEntity getAllBooks();

    ResponseEntity getOneBook(Long id);

    ResponseEntity updateBook(Long id, Book book);

    ResponseEntity deleteBook (Long id);




}
