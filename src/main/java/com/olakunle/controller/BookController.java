package com.olakunle.controller;

import com.olakunle.entity.Book;
import com.olakunle.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("add")
    public ResponseEntity<?> addBook (@RequestBody Book book) {
        return  bookService.addBookToStore(book);
    }

    @GetMapping("/all")
    @Cacheable(value = "book_list")
    public ResponseEntity<?> getAllBooks () {
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    @Cacheable(value = "book", key = "#id")
    public ResponseEntity<?> getSingleBook (@PathVariable Integer id) {
        return bookService.getOneBook(Long.valueOf(id));
    }

    @PutMapping("{id}")
    @CachePut(value = "book", key = "#id")
    public ResponseEntity<?> updateSingleBook (@PathVariable Long id,@RequestBody Book book) {
        return  bookService.updateBook(id, book);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "book", allEntries=true)
    public ResponseEntity<?> deleteSingleBook (@PathVariable Long id) {
        return bookService.deleteBook(id);
    }








}
