package com.darwinmijangos.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darwinmijangos.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
