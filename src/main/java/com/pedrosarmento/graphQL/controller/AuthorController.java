package com.pedrosarmento.graphQL.controller;

import com.pedrosarmento.graphQL.controller.modelInput.NewAuthor;
import com.pedrosarmento.graphQL.model.Author;
import com.pedrosarmento.graphQL.repository.AuthorRepository;
import com.pedrosarmento.graphQL.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    /*
        @QueryMapping usa por padrão o nome utilizado no arquivo schema.graphqls
            - Caso queira mudar o nome é possível passar o nome a ser associado ao do arquivo
     */
    @QueryMapping
    public Author authorById(@Argument String id) {
        return authorRepository.getById(id);
    }


    @MutationMapping
    public Author createAuthor(@Argument NewAuthor newAuthor) {
        Author author = new Author(null, newAuthor.firstName(), newAuthor.lastName());
        return authorRepository.addAuthor(author);
    }
}
