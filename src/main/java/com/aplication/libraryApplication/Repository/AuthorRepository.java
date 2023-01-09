package com.aplication.libraryApplication.Repository;

import com.aplication.libraryApplication.entity.Author;
import com.aplication.libraryApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
