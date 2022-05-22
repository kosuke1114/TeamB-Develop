package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;


	/**
	 * 本情報 Repository
	 */
 @Repository
	public interface BookRepository extends JpaRepository<Book, Long> {
	}
