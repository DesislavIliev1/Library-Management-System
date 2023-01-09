package com.aplication.libraryApplication.Repository;

import com.aplication.libraryApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
