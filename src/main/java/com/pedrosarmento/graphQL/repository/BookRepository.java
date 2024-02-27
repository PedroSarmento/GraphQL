package com.pedrosarmento.graphQL.repository;

import com.pedrosarmento.graphQL.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookRepository {

    private final Map<String, Book> books = new HashMap<String, Book>();

    public Book addBook(Book book) {
        String id = UUID.randomUUID().toString();

        Book bookToBeSave = new Book(id, book.name(), book.pageCount(), book.authorId());
        books.put(bookToBeSave.id(), bookToBeSave);

        return bookToBeSave;
    }

    public Book getById(String id) {
        return books.get(id);
    }

    public List<Book> getAllBookFromAuthorId(String id) {
        return books.values().stream()
                .filter(book -> book.authorId().equals(id))
                .collect(Collectors.toList());
    }
}
