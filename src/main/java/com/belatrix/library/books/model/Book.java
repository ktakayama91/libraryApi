package com.belatrix.library.books.model;

/**
 * Created by anthony on 6/14/17.
 */
public class Book {
    private Integer id;
    private String title;
    private String author;
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
