package com.example.licenta.repository;

import com.example.licenta.model.Poza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PozaRepository extends JpaRepository<Poza, Long> {
    Optional<Poza> findById(Long id);
}
