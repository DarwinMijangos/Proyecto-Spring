package com.darwinmijangos.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darwinmijangos.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}
