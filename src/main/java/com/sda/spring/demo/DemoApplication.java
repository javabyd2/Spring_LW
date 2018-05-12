package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    public BookRepository bookRepository;

	@Autowired
	public AuthorRepository authorRepository;

	@Autowired
	public CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Set<Author> authors = new HashSet<Author>();
		authors.add(new Author("Marian", "Ksiazka"));
		authors.add(new Author("Patryk", "Patyczak"));

		Category category = new Category("Sensacje");



		Book book = new Book("Skacz", category, authors);
		bookRepository.save(book);

		authors.clear();
		authors.add(new Author("fsfs","fsfs"));

		Category category1 = bookRepository.findByTitle("Sensacje");

		Book book1 = new Book("Czas Mija",category1,authors);
		bookRepository.save(book1);

	}
}
