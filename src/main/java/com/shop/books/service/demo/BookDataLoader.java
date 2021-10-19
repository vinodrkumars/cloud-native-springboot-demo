package com.shop.books.service.demo;

import com.shop.books.service.domain.Book;
import com.shop.books.service.domain.BookRepository;
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

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        Book book1 = new Book("Head First Java", "Head First","Java",
                "Head First", "100002", 9.99);
        Book book2 = new Book("Head First EJB", "Head First","EJB",
                "Head First", "100003", 9.99);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
