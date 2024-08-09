package com.darwinmijangos.webapp.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Clientes")
public class Cliente {
    @Id
    private Integer dpi;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String nit;

}
