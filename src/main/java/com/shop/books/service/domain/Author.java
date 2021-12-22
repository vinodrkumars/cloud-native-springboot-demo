package com.shop.books.service.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shop.books.service.persistence.PersistableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Author extends PersistableEntity //implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "author") //, cascade = CascadeType.ALL, orphanRemoval = true
    private List<Book> books = new ArrayList();
    public Author(String name) {
        super();
        this.name = name;
    }
}
