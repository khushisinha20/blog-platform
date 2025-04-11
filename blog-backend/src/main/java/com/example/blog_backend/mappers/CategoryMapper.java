package com.example.blog_backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.example.blog_backend.domain.PostStatus;
import com.example.blog_backend.domain.dtos.CategoryDto;
import com.example.blog_backend.domain.entities.Category;
import com.example.blog_backend.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
	
	@Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
	CategoryDto toDto(Category category);
	
	@Named("calculatePostCount")
	default long calculatePostCount(List<Post> posts) {
		if (null == posts)
			return 0;
		return posts.stream()
				.filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
				.count();
	}
}
