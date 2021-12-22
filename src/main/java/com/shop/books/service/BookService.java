package com.shop.books.service;

import java.util.*;
import java.util.function.Supplier;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shop.books.service.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.Cacheable;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BookService {

	private RestTemplate rest;

	private final BookRepository bookRepository;

	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	//@HystrixCommand(fallbackMethod = "defaultBookList")
	public Iterable<Book> viewBookList(){
		return bookRepository.findAll();
	}

	private Iterable<Book> defaultBookList(){
		List<Book> list = new ArrayList();
		list.add(new Book("Camel in Action", "Java","ManningCo", "123234", 10.00));
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

	public String testCircuitBreaker(){
		return circuitBreakerFactory.create("breaker").
				run(delaySuppplier(5)
						, a -> {
							System.out.println("Call failed, now falling to fallback "+ a );
							Map<String, String> fallback = new HashMap<>();
							fallback.put("hello", "world");
							return "fallback";
						}
				);
	}

	public String delay(int seconds) {
		return rest.getForObject("https://httpbin.org/delay/" + seconds, String.class);
	}

	public Supplier<String> delaySuppplier(int seconds) {
		return () -> this.delay(seconds);
	}


	public List<Book> searchBasedOnTitle( String partialMatch) {
		return bookRepository.findByTitleContainingIgnoreCase(partialMatch);
	}

	public List<Book> searchBasedOnAuthor( String sellerName) {
		return bookRepository.findByAuthorName(sellerName);
		//return null;
	}

	public List<Book> searchOnAnyThing(Example probe){

		return bookRepository.findAll(probe);

	}


	private final AuthorRepository authorRepository;

	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}

}
