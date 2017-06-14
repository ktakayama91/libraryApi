package com.belatrix.library.books.services;

import com.belatrix.library.books.model.Book;
import java.util.List;

/**
 * Created by anthony on 6/14/17.
 */
public interface BookService {
    List<Book> getBooks();

    Integer createBook(Book book);

    Book findBookById(Integer id);

    void deleteBook(Integer id);
}
