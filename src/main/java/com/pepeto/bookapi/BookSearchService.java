package com.pepeto.bookapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookSearchService {
    private static final String SEARCH_API_URL = "https://openlibrary.org/search.json";
    @Autowired
    private final RestTemplate restTemplate;

    public BookSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book searchByISBN(String author){
        String apiUrl = SEARCH_API_URL +"?q="+author;
        BookApiResponse response = restTemplate.getForObject(apiUrl,BookApiResponse.class);
//        List<Book> books = new ArrayList<>();
        /*if (response==null){
            return "Book not found !";
        } else if (response.getBooks().size()>1) {
            String list_of_books="";
            for (Book book : response.getBooks()){
                list_of_books+=book.name();
            }
            return list_of_books;
        }
        else {
            return response.getBooks().getFirst().name();
        }*/
        return response.getBooks().getFirst();
    }
}
