package com.darwinmijangos.webapp.biblioteca.service;

import com.darwinmijangos.webapp.biblioteca.model.Libro;

import java.util.List;

public interface ILibroService {
    public List<Libro> listarLibros();
 
    public Libro guardarLibro(Libro libro);
 
    public Libro buscarLibro(Long id);
 
    public void eilimnaLibro(Libro libro);
}
