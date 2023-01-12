package com.olakunle.repository;


import com.olakunle.entity.Book;
import com.olakunle.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookProcess {

    private final RedisTemplate redisTemplate;

    private final AtomicLong atomicLong = new AtomicLong() ;

    public String addBookToHash(Book book) {
        redisTemplate.opsForHash().put(RedisUtils.BOOK_HASH, atomicLong.incrementAndGet(), book);
        log.info("Newly added object");
        return "Book added successfully";
    }

    // Create Retrieve Update Delete

    public List<Book> getAllBooks () {
        List<Book> bookList = redisTemplate.opsForHash().values(RedisUtils.BOOK_HASH);
        return bookList;
    }

}
