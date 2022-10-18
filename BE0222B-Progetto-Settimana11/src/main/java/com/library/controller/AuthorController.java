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

import com.library.model.Author;
import com.library.service.impl.AuthorServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorServiceImpl authorS;

	@GetMapping("/getAllAuthors")
	public ResponseEntity<Page<Author>> getAllAuthors(Pageable pageable) {
		Page<Author> authors = authorS.getAllAuthors(pageable);
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	@GetMapping("/getAuthorById/{idAuthor}")
	public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long idAuthor) {
		Optional<Author> author = authorS.getAuthorById(idAuthor);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	@PostMapping("/addAuthor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		return new ResponseEntity<>(authorS.addAuthor(author), HttpStatus.OK);
	}

	@PutMapping("/updateAuthor/{idAuthor}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long idAuthor, @RequestBody Author author) {
		return new ResponseEntity<>(authorS.updateAuthor(idAuthor, author), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAuthor/{idAuthor}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<String> deleteAuthor(@PathVariable Long idAuthor) {
		authorS.deleteAuthor(idAuthor);
		return new ResponseEntity<>("Author removed!", HttpStatus.OK);
	}
}
