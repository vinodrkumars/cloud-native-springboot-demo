package com.shop.books.service.domain;

import com.shop.books.service.persistence.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import(JpaConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryJpaTests {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findBookByIsbnWhenExisting(){
        String bookIsbn = "100010";
        Book expectedBook = new Book("Head First EJB", "Head First",
                "Head First", "1000011", 9.99);

        Author seller = new Author("Amazon");


        entityManager.persist(expectedBook);

        Optional<Book> actualBook = bookRepository.findByIsbn(bookIsbn);
        assertThat(actualBook).isPresent();
        assertThat(actualBook.get().getIsbn()).isEqualTo(expectedBook.getIsbn());
    }


}
