package com.example.blog_backend.services;

import java.util.List;

import com.example.blog_backend.domain.entities.Category;

public interface CategoryService {
	List<Category> listCategories();
	Category createCategory(Category category);
}
