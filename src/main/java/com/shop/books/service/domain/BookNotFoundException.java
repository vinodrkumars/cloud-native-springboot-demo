package com.shop.books.service.domain;

public class BookNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String isbn) {
		super("The book with isbn " + isbn + " was not found." );
	}

}
