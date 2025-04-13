package com.example.blog_backend.services;

import java.util.List;
import java.util.UUID;

import com.example.blog_backend.domain.entities.Category;

public interface CategoryService {
	List<Category> listCategories();
	Category createCategory(Category category);
	void deleteCategory(UUID id);
}
