package com.springBoot.sbjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbJpaApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(SbJpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SbJpaApplication.class, args);
	}
	

    @Autowired
    private BookRepository repository;

    @Override
    public void run(String... args) {

        log.info("Iniciando Aplicación ...");

        repository.save(new Book("Java"));
        repository.save(new Book("React"));
        repository.save(new Book("Spring"));
        repository.save(new Book("ReactJpa"));

        System.out.println("\nRetorna todos los libros");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nPrimer Libro de la lista");
        repository.findById(1l).ifPresent(x -> System.out.println(x));
        
        System.out.println("\nTercer Libro de la lista");
        repository.findById(3l).ifPresent(x -> System.out.println(x));

        System.out.println("\nBusca el libro por el nombre React");
        repository.findByName("React").forEach(x -> System.out.println(x));

    }

}