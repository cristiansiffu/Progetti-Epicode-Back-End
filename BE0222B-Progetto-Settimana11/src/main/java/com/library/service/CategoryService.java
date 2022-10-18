package com.library.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.library.model.Category;

public interface CategoryService {

	public Page<Category> getAllCategories(Pageable pageable);

	public Optional<Category> getCategoryById(Long idCategory);

	public Category addCategory(Category category);

	public Category updateCategory(Long idCategory, Category category);

	public void deleteCategory(Long idCategory);

}
