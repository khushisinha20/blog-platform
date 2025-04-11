package com.example.blog_backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_backend.domain.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, UUID> {

}
