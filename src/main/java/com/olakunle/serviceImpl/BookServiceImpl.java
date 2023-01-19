package com.olakunle.serviceImpl;

import com.olakunle.entity.Book;
import com.olakunle.repository.BookRepository;
import com.olakunle.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }




    @Override
    public ResponseEntity getAllBooks() {
        List<Book> books  = bookRepository.findAll();

        log.info("Book List: {} " , books);
        return ResponseEntity.ok().body(books);
    }

    @Override
    public ResponseEntity getOneBook(Long id) {
        if (bookRepository.existsById(id)){
            Optional<Book> book = bookRepository.findById(id);

            log.info("Book with ID: {}", book );
            if (book.isPresent())
                return ResponseEntity.ok().body(book.get());
            else
                return ResponseEntity.ok().body("Book with ID: " + id + " not found");
        }
        else {
            log.error("Book with ID: {} not found", id);
            return ResponseEntity.ok().body("Book with ID: " + id + " not found");
        }
    }

    @Override
    public ResponseEntity updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)){


            Book bk = bookRepository.findById(id).get();
            bk.setName(book.getName());
            bk.setPrice(book.getPrice());
            bk.setAuthor(book.getAuthor());
            bookRepository.save(bk);
            log.info("Updated book with ID: {}", id);
            return ResponseEntity.ok().body(bk);
        }
        else {
            log.error("Book with ID: {} not found", id);
            return ResponseEntity.ok().body("Book with ID: " + id + " not found");
        }
    }

    @Override
    public ResponseEntity deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            log.info("Successfully deleted Book with id: {}", id);
            return ResponseEntity.ok().body("Successfully deleted Book with id: " + id);
        }
        else  {
            log.error("Book with ID: {} not found", id);
            return ResponseEntity.ok().body("Book with ID: " + id + " not found");
        }
    }

    public ResponseEntity addBookToStore (Book book) {
        bookRepository.save(book);
        log.info("Book with ID: {} successfully added", book.getId());
        return ResponseEntity.ok().body("Book successfully added");
    }

}
