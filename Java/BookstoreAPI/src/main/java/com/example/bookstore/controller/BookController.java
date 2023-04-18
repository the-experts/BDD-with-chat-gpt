package com.example.bookstore.controller;// BookController.java
import com.example.bookstore.domain.Book;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Controller("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @Inject
    public BookController() {
        // Initialize with a sample book
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780141182636", 9.99));
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return books;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Book createBook(@Body Book book) {
        books.add(book);
        return book;
    }

    @Get("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) throws Exception {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new Exception("Book not found for ISBN: " + isbn);
    }

    @Put("/{isbn}")
    public Book updateBook(@PathVariable String isbn, @Body Book book) throws Exception {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.set(i, book);
                return book;
            }
        }
        throw new Exception("Book not found for ISBN: " + isbn);
    }

    @Delete("/{isbn}")
    public HttpStatus deleteBook(@PathVariable String isbn) throws Exception {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                return HttpStatus.OK;
            }
        }
        throw new Exception("Book not found for ISBN: " + isbn);
    }

}
