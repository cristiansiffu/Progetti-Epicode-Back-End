package com.library.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.library.model.Author;

public interface AuthorService {

	public Page<Author> getAllAuthors(Pageable pageable);

	public Optional<Author> getAuthorById(Long idAuthor);

	public Author addAuthor(Author author);

	public Author updateAuthor(Long idAuthor, Author author);

	public void deleteAuthor(Long idAuthor);

}
