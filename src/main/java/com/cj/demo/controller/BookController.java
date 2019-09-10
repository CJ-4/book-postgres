package com.cj.demo.controller;

import com.cj.demo.model.Book;
import com.cj.demo.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public  String putBook(){
        return "put";
    }

    @PatchMapping()
    public  String patchBook() {
        return "patch";
    }

    @DeleteMapping()
    public  String deleteBook() {
        return "delete";
    }

}
