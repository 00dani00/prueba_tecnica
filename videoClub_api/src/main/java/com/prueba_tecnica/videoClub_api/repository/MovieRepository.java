package com.prueba_tecnica.videoClub_api.repository;

import com.prueba_tecnica.videoClub_api.modelo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
