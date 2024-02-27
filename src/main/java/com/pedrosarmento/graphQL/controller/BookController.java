package com.pedrosarmento.graphQL.controller;

import com.pedrosarmento.graphQL.controller.modelInput.NewBook;
import com.pedrosarmento.graphQL.model.Author;
import com.pedrosarmento.graphQL.model.Book;
import com.pedrosarmento.graphQL.repository.AuthorRepository;
import com.pedrosarmento.graphQL.repository.BookRepository;
import com.pedrosarmento.graphQL.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookRepository.getById(id);
    }

    @MutationMapping
    public Book createBook(@Argument NewBook newBook) {
        Book book = new Book(null, newBook.name(), newBook.pageCount(), newBook.authorId());
        return bookRepository.addBook(book);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.getById(book.authorId());
    }
}
