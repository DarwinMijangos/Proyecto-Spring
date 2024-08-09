package com.darwinmijangos.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darwinmijangos.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
