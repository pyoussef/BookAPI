package com.pepeto.bookapi;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookSearchService bookSearchService;

    public BookController(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    @GetMapping("/getbook/{isbn}")
    @Cacheable("bookNames")
    public Book getBook(@PathVariable String isbn){
        return bookSearchService.searchByISBN(isbn);
    }
}
