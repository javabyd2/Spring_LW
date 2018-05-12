package com.sda.spring.demo.controller;

import com.sda.spring.demo.Services.BookService;
import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookService bookRService;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> showBookList(){
        return bookRService.getBooks();
    }
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> showAuthorList(){
        return authorRepository.findAll();
    }
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> showCategoryList(){
        return categoryRepository.findAll();
    }


}
