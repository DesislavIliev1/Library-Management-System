package com.aplication.libraryApplication.Repository;

import com.aplication.libraryApplication.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
