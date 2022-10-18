package com.library.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.library.model.Book;

public interface BookService {

	public Page<Book> getAllBooks(Pageable pageable);

	public Optional<Book> getBookById(Long idBook);

	public Book addBook(Book book);

	public Book updateBook(Long idBook, Book book);

	public void deleteBook(Long idBook);

	public Page<Book> getBooksByAuthor(Long idAuthor, Pageable pageable);

	public Page<Book> getBooksByCategory(Long idCategory, Pageable pageable);

}
