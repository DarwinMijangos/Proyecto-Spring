package com.darwinmijangos.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darwinmijangos.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}