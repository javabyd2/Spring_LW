package com.sda.spring.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToOne
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns =
    @JoinColumn(name ="book_id", referencedColumnName = "id"),
            inverseJoinColumns =
                    @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> authors;

    public Book(String title) {
        this.title = title;

    }

    public Book() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


}
