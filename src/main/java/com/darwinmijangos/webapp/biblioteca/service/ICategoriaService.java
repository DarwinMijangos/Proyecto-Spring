package com.darwinmijangos.webapp.biblioteca.service;
    
import java.util.List;

import com.darwinmijangos.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {
    
    public List<Categoria> listarCategorias();
    
    public Categoria buscarCategoriaPorId(Long id);

    public Categoria guardarCategoria(Categoria categoria);

    public void eliminarCategoria(Categoria categoria);

    public Boolean verificarCategoriaDuplicada(Categoria categorianueva);
}
