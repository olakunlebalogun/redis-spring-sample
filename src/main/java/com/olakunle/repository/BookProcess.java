package com.olakunle.repository;


import com.olakunle.entity.Book;
import com.olakunle.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookProcess {

    private final RedisTemplate redisTemplate;


    public String addBookToHash (Book book) {
        redisTemplate.opsForHash().put(RedisUtils.BOOK_HASH, book.getId(), book);
        log.info("Newly added object");
        return "Book added successfully";
    }
}
