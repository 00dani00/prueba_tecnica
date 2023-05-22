package com.prueba_tecnica.videoClub_api.repository;

import com.prueba_tecnica.videoClub_api.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findOneByEmail(String email);
}
