package com.springBoot.sbjpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void testFindByName() {        
        entityManager.persist(new Book("Java"));
        List<Book> books = repository.findByName("Java");  
        System.out.println("\nBooks :" +repository.findByName("Java"));
        //.findAll().forEach(x -> System.out.println(x));
        assertEquals(2, books.size());

        assertThat(books).extracting(Book::getName).containsOnly("Java");

    }

}