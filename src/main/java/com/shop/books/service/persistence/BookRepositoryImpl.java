package com.shop.books.service.persistence;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.shop.books.service.domain.Book;
import com.shop.books.service.domain.BookRepository;

//@Repository
public class BookRepositoryImpl //implements BookRepository
{
/*
	private static final Map<String, Book> books = new ConcurrentHashMap<>();
	
	@Override
	public Collection<Book> findAll(){
		return books.values();
		
	}
	@Override
	public Optional<Book> findByIsbn(String isbn){
		return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
	}
	@Override
	public boolean existsByIsbn(String isbn) {
		return books.get(isbn) != null;
	}
	@Override
	public Book save(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}
	@Override
	public void DeleteByIsbn(String isbn) {
		books.remove(isbn);
	}

 */
}
