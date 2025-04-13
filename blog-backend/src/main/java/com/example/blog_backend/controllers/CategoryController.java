package com.example.blog_backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_backend.domain.dtos.CategoryDto;
import com.example.blog_backend.domain.dtos.CreateCategoryRequest;
import com.example.blog_backend.domain.entities.Category;
import com.example.blog_backend.mappers.CategoryMapper;
import com.example.blog_backend.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	private final CategoryMapper categoryMapper;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> listCategories() {
		List<Category> categories = categoryService.listCategories();
		return ResponseEntity.ok(
				categories.stream().map(categoryMapper::toDto).toList()
		);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
		Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
		Category savedCategory = categoryService.createCategory(categoryToCreate);
		return new ResponseEntity<CategoryDto>(
				categoryMapper.toDto(savedCategory),
				HttpStatus.CREATED
		);
	}
}
