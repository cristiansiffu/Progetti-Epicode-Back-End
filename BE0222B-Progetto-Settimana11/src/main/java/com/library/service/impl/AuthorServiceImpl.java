package com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.model.Author;
import com.library.repository.AuthorRepository;
import com.library.service.AuthorService;
import com.library.util.exception.LibraryException;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorR;

	@Override
	public Page<Author> getAllAuthors(Pageable pageable) {
		return authorR.findAll(pageable);
	}

	@Override
	public Optional<Author> getAuthorById(Long idAuthor) {
		if (authorR.findById(idAuthor).isEmpty()) {
			throw new LibraryException("Author not found!");
		}
		return authorR.findById(idAuthor);
	}

	@Override
	public Author addAuthor(Author author) {
		return authorR.save(author);
	}

	@Override
	public Author updateAuthor(Long idAuthor, Author author) {
		Optional<Author> authorUpdated = authorR.findById(idAuthor);
		if (authorUpdated.isEmpty()) {
			throw new LibraryException("Author not found!");
		}
		authorUpdated.get().setFirstName(author.getFirstName());
		authorUpdated.get().setLastName(author.getLastName());
		return authorUpdated.get();
	}

	@Override
	public void deleteAuthor(Long idAuthor) {
		Optional<Author> author = authorR.findById(idAuthor);
		if (author.isEmpty()) {
			throw new LibraryException("Author not found!");
		}
		authorR.deleteById(idAuthor);
	}

}
