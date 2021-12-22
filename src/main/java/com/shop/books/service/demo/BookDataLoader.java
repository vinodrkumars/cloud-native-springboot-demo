package com.shop.books.service.demo;

import com.shop.books.service.domain.Book;
import com.shop.books.service.domain.BookRepository;
import com.shop.books.service.domain.Author;
import com.shop.books.service.domain.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("test-data")
@RequiredArgsConstructor
public class BookDataLoader {

    private final BookRepository bookRepository;

    private final AuthorRepository sellerRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        Book book1 = new Book("Head First Java", "Head First",
                "Head First", "100002", 9.99);
        Book book2 = new Book("Head First EJB", "Head First",
                "Head First", "100003", 9.99);

        Author seller1 = new Author("Amazon.com");
        Author seller2 = new Author("author2");
        book1.setAuthor(seller1);
        book2.setAuthor(seller2);

        sellerRepository.save(seller1);
        bookRepository.save(book1);

        sellerRepository.save(seller2);
        bookRepository.save(book2);

    }
}
