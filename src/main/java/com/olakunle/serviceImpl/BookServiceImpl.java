package com.olakunle.serviceImpl;

import com.olakunle.entity.Book;
import com.olakunle.repository.BookRepository;
import com.olakunle.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ResponseEntity getAllBooks() {
        return null;
    }

    @Override
    public ResponseEntity getOneBook(Long id) {
        return null;
    }

    @Override
    public ResponseEntity updateBook(Long id) {
        return null;
    }

    @Override
    public ResponseEntity deleteBook(Long id) {
        return null;
    }

    public ResponseEntity addBookToStore (Book book) {

        return null;
    }

}
