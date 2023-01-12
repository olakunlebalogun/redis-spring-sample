package com.olakunle.controller;

import com.olakunle.entity.Book;
import com.olakunle.repository.BookProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book/")
@RequiredArgsConstructor
public class BookController {

    private final BookProcess bookProcess;



    @PostMapping("add")
    public ResponseEntity<String> addBook (@RequestBody Book book) {
        String result = bookProcess.addBookToHash(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity getAllBookEntries() {
        Map<String, Object> books = bookProcess.getAllBooks();
        return ResponseEntity.ok().body(books);
    }


}
