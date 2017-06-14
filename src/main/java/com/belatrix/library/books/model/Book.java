package com.belatrix.library.books.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by anthony on 6/14/17.
 */
public class Book {
    private Integer id;

    @NotNull
    @Size(min = 1, max = 150, message = "The length of title should be between 1 to 150")
    private String title;

    @NotNull
    @Size(min = 1, max = 150, message = "The length of author should be between 1 to 150")
    private String author;

    @NotNull
    @Size(min = 1, max = 150, message = "The length of editorial should be between 1 to 150")
    private String editorial;

    private Integer status;

    public Book(){

    }

    public Book(Integer id, String title, String author, String editorial) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.status = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
