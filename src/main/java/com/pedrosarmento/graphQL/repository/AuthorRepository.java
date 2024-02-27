package com.pedrosarmento.graphQL.repository;

import com.pedrosarmento.graphQL.model.Author;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthorRepository {
    private final Map<String, Author> authors = new HashMap<String, Author>();
    public Author addAuthor(Author author) {
        String id = UUID.randomUUID().toString();

        Author authorToBeSave = new Author(id, author.firstName(), author.lastName());
        authors.put(authorToBeSave.id(), authorToBeSave);

        return authorToBeSave;
    }

    public Author getById(String id) {
        return authors.get(id);
    }
}
