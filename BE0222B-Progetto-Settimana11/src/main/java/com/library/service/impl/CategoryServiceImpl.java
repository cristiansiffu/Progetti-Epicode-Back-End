package com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.model.Category;
import com.library.repository.CategoryRepository;
import com.library.service.CategoryService;
import com.library.util.exception.LibraryException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryR;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryR.findAll(pageable);
	}

	@Override
	public Optional<Category> getCategoryById(Long idCategory) {
		if (categoryR.findById(idCategory).isEmpty()) {
			throw new LibraryException("Category not found!");
		}
		return categoryR.findById(idCategory);
	}

	@Override
	public Category addCategory(Category category) {
		return categoryR.save(category);
	}

	@Override
	public Category updateCategory(Long idCategory, Category category) {
		Optional<Category> categoryUpdated = categoryR.findById(idCategory);
		if (categoryUpdated.isEmpty()) {
			throw new LibraryException("Category not found!");
		}
		categoryUpdated.get().setName(category.getName());
		return categoryUpdated.get();
	}

	@Override
	public void deleteCategory(Long idCategory) {
		Optional<Category> category = categoryR.findById(idCategory);
		if (category.isEmpty()) {
			throw new LibraryException("Category not found!");
		}
		categoryR.deleteById(idCategory);
	}

}
