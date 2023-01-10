package com.olakunle.controller;

import com.olakunle.entity.Book;
import com.olakunle.repository.BookProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
