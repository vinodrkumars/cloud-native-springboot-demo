package com.shop.books.service.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
//public interface BookRepository extends CrudRepository<Book, Long> {
	//Collection<Book> findAll();
	Optional<Book> findByIsbn(String isbn);
	boolean existsByIsbn(String isbn);
	//Book save(Book book);
	@Transactional
	void deleteByIsbn(String isbn);

	List<Book> findByTitleContainingIgnoreCase(String partialMatch);

	List<Book> findByAuthorName(String name);
}
