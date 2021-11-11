package com.shop.books.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import com.shop.books.service.domain.Book;
import com.shop.books.service.domain.BookAlreadyExistsException;
import com.shop.books.service.domain.BookNotFoundException;
import com.shop.books.service.domain.BookRepository;

import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.Cacheable;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	@HystrixCommand(fallbackMethod = "defaultBookList")
	public Iterable<Book> viewBookList(){
		return bookRepository.findAll();
	}

	private Iterable<Book> defaultBookList(){
		List<Book> list = new ArrayList();
		list.add(new Book("Camel in Action", "Java", "Manning","ManningCo", "123234", 10.00));
		return list;
	}

	//@Cacheable(value="bookCache", key="isbn")
	public Book viewBookDetails(String isbn){
		return bookRepository.findByIsbn(isbn).orElseThrow(()-> new BookNotFoundException(isbn));
	}
	
	public Book addBookToCatalog(Book book) {
		if(bookRepository.existsByIsbn(book.getIsbn())) {
			throw new BookAlreadyExistsException(book.getIsbn());
		};
		return bookRepository.save(book);
	}
	
	public void removeBookFromCatalog(String isbn) {
		if(!bookRepository.existsByIsbn(isbn)) {
			throw new BookNotFoundException(isbn);
		}
		bookRepository.deleteByIsbn(isbn);
	}
	
	public Book editBookDetails(String isbn, Book book) {
		Optional<Book> existingBook = bookRepository.findByIsbn(isbn);
		if (existingBook.isEmpty()) {
			return addBookToCatalog(book);
		}
		Book bookTemplate = existingBook.get();
		bookTemplate.setTitle(book.getTitle());
		bookTemplate.setAuthor(book.getAuthor());
		bookTemplate.setGenre(book.getGenre());
		bookTemplate.setPrice(book.getPrice());
		bookTemplate.setPublisher(book.getPublisher());
		return bookRepository.save(bookTemplate);
	}
}
