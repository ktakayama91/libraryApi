package com.belatrix.library.books.services;

import com.belatrix.library.books.model.Book;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anthony on 6/14/17.
 */
public class BookServiceImpl implements BookService {
    private static List<Book> books= new ArrayList<>(Arrays
            .asList(
                    new Book(1, "El caballero Carmelo", "Abraham Valdelomar", "San Marcos")
                    ));
    private static Integer ACTIVE_BOOK = 1;
    private static Integer ID = 1;

    @Override
    public List<Book> getBooks() {
        return books.stream()
                .filter(item -> item.getStatus().equals(ACTIVE_BOOK))
                .collect(Collectors.toList());
    }

    @Override
    public Integer createBook(Book b) {
        books.add(new Book(++ID, b.getTitle(), b.getAuthor(), b.getEditorial()));
        return ID;
    }

    @Override
    public Book findBookById(Integer id) {
        Book existentBook = books.stream()
                .filter(item -> item.getId().equals(id))
                .filter(item -> item.getStatus() == 1)
                .findFirst()
                .orElse(null);

        if(existentBook == null) {
            throw new NotFoundException("Book does not exist");
        }

        return existentBook;
    }

    @Override
    public void deleteBook(Integer id) {
        Book existentBook = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);

        if (existentBook == null) {
            throw new NotFoundException("Book does not exist");
        }

        books.remove(existentBook);
    }

    @Override
    public void updateBook(Book b, Integer id) {
        Book existentBook = findBookById(id);
        b.setId(id);
        b.setStatus(existentBook.getStatus());
        deleteBook(id);
        books.add(b);
    }
}
