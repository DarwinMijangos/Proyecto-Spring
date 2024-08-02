package com.darwinmijangos.webapp.biblioteca.model;

import jakarta.persistence.Entity;

@Entity
@Data
@ToString
@Table(name = "Categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCategoria;
}
