package com.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Category;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;
import com.library.service.BookService;
import com.library.util.exception.LibraryException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookR;

	@Autowired
	private AuthorRepository authorR;

	@Autowired
	private CategoryRepository categoryR;

	@Override
	public Page<Book> getAllBooks(Pageable pageable) {
		return bookR.findAll(pageable);
	}

	@Override
	public Optional<Book> getBookById(Long idBook) {
		if (bookR.findById(idBook).isEmpty()) {
			throw new LibraryException("Book not found!");
		}
		return bookR.findById(idBook);
	}

	@Override
	public Book addBook(Book book) {
		List<Author> authors = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		for (Author a : book.getAuthors()) {
			authors.add(authorR.findByFirstNameAndLastName(a.getFirstName(), a.getLastName()).get());
		}
		for (Category c : book.getCategories()) {
			categories.add(categoryR.findByName(c.getName()).get());
		}
		book.setAuthors(authors);
		book.setCategories(categories);
		return bookR.save(book);
	}

	@Override
	public Book updateBook(Long idBook, Book book) {
		Optional<Book> bookUpdated = bookR.findById(idBook);
		if (bookUpdated.isEmpty()) {
			throw new LibraryException("Book not found!");
		}
		bookUpdated.get().setPrice(book.getPrice());
		bookUpdated.get().setTitle(book.getTitle());
		return bookUpdated.get();
	}

	@Override
	public void deleteBook(Long idBook) {
		Optional<Book> book = bookR.findById(idBook);
		if (book.isEmpty()) {
			throw new LibraryException("Book not found!");
		}
		bookR.deleteById(idBook);
	}

	@Override
	public Page<Book> getBooksByAuthor(Long idAuthor, Pageable pageable) {
		return bookR.findByAuthor(idAuthor, pageable);
	}

	@Override
	public Page<Book> getBooksByCategory(Long idCategory, Pageable pageable) {
		return bookR.findByCategory(idCategory, pageable);
	}

}
