package com.sda.spring.demo.Services;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(){
        /**
         * dodatkowa logika
         */

        return bookRepository.findAll();
    }
}
