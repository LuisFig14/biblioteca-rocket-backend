package com.fernando.biblioteca_rocket.service.book;

import com.fernando.biblioteca_rocket.mapper.book.BookMapper;
import com.fernando.biblioteca_rocket.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public Book createBook(Book book) {
        bookMapper.createBook(book);
        return book;
    }

    public Optional<Book> getBookById(Long idBook){
        return Optional.ofNullable(bookMapper.getBookById(idBook));
    }

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }

    public boolean updateBook(Long idBook, Book book) {
        Optional<Book> existing = getBookById(idBook);
        if (existing.isPresent()) {
            book.setIdBook(idBook);
            bookMapper.updateBook(book);
            return true;
        }
        return false;
    }

    public boolean deleteBook(Long idBook) {
        Optional<Book> existing = getBookById(idBook);
        if (existing.isPresent()) {
            bookMapper.deleteBook(idBook);
            return true;
        }
        return false;
    }
}
