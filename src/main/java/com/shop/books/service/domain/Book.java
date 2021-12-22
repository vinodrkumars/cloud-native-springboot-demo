package com.shop.books.service.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shop.books.service.persistence.PersistableEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
//@Getter @Setter
public class Book extends PersistableEntity {

	@Id
	@GeneratedValue
	private long id;

	private String title;
	private String genre;
	//@ManyToOne(cascade = {CascadeType.ALL})
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="author_id")
	private Author author;
	private String publisher;
	@NotBlank(message = "The book ISBN must be defined.")
	private String isbn;
	private Double price;
	/*
	@OneToMany(mappedBy = "isbn")
	private List<Author> author = new ArrayList<>();
*/
	public Book(String title, String genre, String publisher, String isbn, double price) {
		super();
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.isbn = isbn;
		this.price = price;
	}

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
