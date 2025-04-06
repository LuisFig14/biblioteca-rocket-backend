package com.fernando.biblioteca_rocket.controller;

import com.fernando.biblioteca_rocket.model.book.Book;
import com.fernando.biblioteca_rocket.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    //Create book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book bookCreated = bookService.createBook(book);
        return new ResponseEntity<>(bookCreated , HttpStatus.CREATED);
    }

    //Get book by id
    @GetMapping("/{idBook}")
    public ResponseEntity<Book> getBookById(@PathVariable Long idBook){
        Optional<Book> book = bookService.getBookById(idBook);
        return book.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        boolean updated = bookService.updateBook(id, book);
        if (updated) {
            return ResponseEntity.ok("Book updated correctly");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.ok("Book deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }





}
