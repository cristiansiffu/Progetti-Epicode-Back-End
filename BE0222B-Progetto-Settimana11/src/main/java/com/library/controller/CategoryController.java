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

import com.library.model.Category;
import com.library.service.impl.CategoryServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryS;

	@GetMapping("/getAllCategories")
	public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {
		Page<Category> categories = categoryS.getAllCategories(pageable);
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/getCategoryById/{idCategory}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long idCategory) {
		Optional<Category> category = categoryS.getCategoryById(idCategory);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("/addCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryS.addCategory(category), HttpStatus.OK);
	}

	@PutMapping("/updateCategory/{idCategory}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Category> updateCategory(@PathVariable Long idCategory, @RequestBody Category category) {
		return new ResponseEntity<>(categoryS.updateCategory(idCategory, category), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCategory/{idCategory}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<String> deleteAuthor(@PathVariable Long idCategory) {
		categoryS.deleteCategory(idCategory);
		return new ResponseEntity<>("Category removed!", HttpStatus.OK);
	}
}