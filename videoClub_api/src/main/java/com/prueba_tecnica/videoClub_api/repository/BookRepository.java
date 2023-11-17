package com.prueba_tecnica.videoClub_api.repository;

import com.prueba_tecnica.videoClub_api.modelo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
