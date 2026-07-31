package com.example.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.Books;

public interface BookRepository extends JpaRepository<Books,Integer> {
		Optional<Books> findByName(String name);
}
