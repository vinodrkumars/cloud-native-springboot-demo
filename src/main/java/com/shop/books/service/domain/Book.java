package com.shop.books.service.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.shop.books.service.persistence.PersistableEntity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
//@Getter @Setter
public class Book extends PersistableEntity {

	private String title;
	private String genre;
	private String author;
	private String publisher;
	@NotBlank(message = "The book ISBN must be defined.")
	private String isbn;
	private Double price;
	
	/*
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	
	}
	public Book(int id, String title, String genre, String author, String publisher, String iSBN) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	*/
}
