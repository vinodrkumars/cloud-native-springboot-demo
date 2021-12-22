package com.shop.books;

import com.shop.books.service.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.shop.books.service.BookService;
import com.shop.books.service.domain.Book;

import lombok.RequiredArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@EnableSwagger2 
public class BookController {

	@Autowired
	private final BookService bookService;

	//@CrossOrigin(origins = "http://localhost:4280", allowedHeaders = "*")
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

	@GetMapping("/testCircuitBreaker")
	public String testCircuitBreaker() {
			return bookService.testCircuitBreaker();
	}

	@RequestMapping(value="{id}/seller/{sellerId}", method=RequestMethod.PUT)
	public String getBookSeller(@PathVariable String id, @PathVariable String sellerId){
		return "seller of this book :" + id + " is :" + sellerId;
	}

	@GetMapping("/search/{partialMatch}")
	public List<Book> searchBasedOnTitle(@PathVariable String partialMatch) {
		return bookService.searchBasedOnTitle(partialMatch);
	}
	@GetMapping("/author/{authorName}")
	public List<Book> searchBasedOnAuthor(@PathVariable String authorName) {
		return bookService.searchBasedOnAuthor(authorName);
	}

	@GetMapping("/search")
	List<Book> searchOnAnyThing(@RequestParam(name = "title", required = false) String title,
								@RequestParam(name = "sellerName", required = false) String sellerName){
		Book example = new Book();
		example.setTitle(title);
		example.setAuthor(new Author(sellerName));

		Example<Book> probe = Example.of(example);
		return bookService.searchOnAnyThing(probe);

	}
	@GetMapping("/allAuthors")
	List<Author> getAuthors(){
		return bookService.getAuthors();
	}
}
