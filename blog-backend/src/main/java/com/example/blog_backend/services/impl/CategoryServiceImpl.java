package com.example.blog_backend.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog_backend.domain.entities.Category;
import com.example.blog_backend.repositories.CategoryRepository;
import com.example.blog_backend.services.CategoryService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listCategories() {
		return categoryRepository.findAllWithPostCount();
	}
	
	@Override
	@Transactional
	public Category createCategory(Category category) {
		if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
			throw new IllegalArgumentException("Category already exists with name " + category.getName());
		}
		
		return categoryRepository.save(category);
	}
}
