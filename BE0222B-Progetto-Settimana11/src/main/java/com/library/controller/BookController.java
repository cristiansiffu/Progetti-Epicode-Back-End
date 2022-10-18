package com.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.service.impl.BookServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookServiceImpl bookS;

	@GetMapping("/getAllBooks")
	public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable) {
		Page<Book> books = bookS.getAllBooks(pageable);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/getBookById/{idBook}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long idBook) {
		Optional<Book> book = bookS.getBookById(idBook);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping("/addBook")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookS.addBook(book), HttpStatus.OK);
	}

	@PutMapping("/updateBook/{idBook}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Book> updateBook(@PathVariable Long idBook, @RequestBody Book book) {
		return new ResponseEntity<>(bookS.updateBook(idBook, book), HttpStatus.OK);
	}

	@DeleteMapping("/deleteBook/{idBook}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<String> deleteBook(@PathVariable Long idBook) {
		bookS.deleteBook(idBook);
		return new ResponseEntity<>("Book removed!", HttpStatus.OK);
	}

	@GetMapping("/getBooksByIdAuthor/{idAuthor}")
	public ResponseEntity<Page<Book>> getBooksByIdAuthor(@PathVariable Long idAuthor, Pageable pageable) {
		Page<Book> books = bookS.getBooksByAuthor(idAuthor, pageable);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/getBooksByIdCategory/{idCategory}")
	public ResponseEntity<Page<Book>> getBooksByIdCategory(@PathVariable Long idCategory, Pageable pageable) {
		Page<Book> books = bookS.getBooksByCategory(idCategory, pageable);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

}
