package com.shop.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.books.service.BookService;
import com.shop.books.service.domain.Book;

import lombok.RequiredArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@EnableSwagger2 
public class BookController {

	private final BookService bookService;
	
	@GetMapping
	public Iterable<Book> get(){
		return bookService.viewBookList() ;
	}
	@GetMapping("{isbn}")
	public Book getByIsbn(@PathVariable String isbn) {
		return bookService.viewBookDetails(isbn);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book post(@RequestBody Book book) {
		return bookService.addBookToCatalog(book);
	}
	@DeleteMapping("{isbn}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String isbn) {
		bookService.removeBookFromCatalog(isbn);
	}
	@PutMapping("{isbn}")
	public Book put(@PathVariable String isbn, @RequestBody Book book) {
		return bookService.editBookDetails(isbn, book);
	}
	
	@GetMapping("/hello")
	public void hello() {
		throw new IllegalArgumentException(); 
		
		//return "Hello World!";
	}
}