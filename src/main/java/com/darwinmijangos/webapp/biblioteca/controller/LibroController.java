package com.darwinmijangos.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darwinmijangos.webapp.biblioteca.model.Libro;
import com.darwinmijangos.webapp.biblioteca.service.LibroService;

@Controller
@RestController
@RequestMapping(name = "")
public class LibroController {
    @Autowired
    LibroService libroService;
 
    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> listarLibros(){
        try {
            return ResponseEntity.ok(libroService.listarLibros());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @PostMapping("/libro")
    public ResponseEntity<Map<String, String>> agregarLibro(@RequestBody Libro libro){
        Map<String, String> response = new HashMap<>();
        try {
            libroService.guardarLibro(libro);
            response.put("Message", "libro creado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "hubo un error al crear el libro!");
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @PutMapping("/libro")
    public ResponseEntity<Map<String, String>> editarLibro(@RequestBody Long id, @RequestBody Libro libroNuevo){
        Map<String, String> response = new HashMap<>();
        try {
            Libro libro = libroService.buscarLibro(id);
            libro.setIsbn(libroNuevo.getIsbn());
            libro.setNombre(libroNuevo.getNombre());
            libro.setSinopsis(libroNuevo.getSinopsis());
            libro.setAutor(libroNuevo.getAutor());
            libro.setEditorial(libroNuevo.getEditorial());
            libro.setDisponibilidad(libroNuevo.getDisponibilidad());
            libro.setNumeroEstanteria(libroNuevo.getNumeroEstanteria());
            libro.setCluster(libroNuevo.getCluster());
            libro.setCategoria(libroNuevo.getCategoria());
            libroService.guardarLibro(libro);
            response.put("Message", "El libro se ha editado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "el libro no se pudo editar!");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @DeleteMapping("/libro")
    public ResponseEntity<Map<String, String>> eliminarLibro(@RequestBody Long id){
        Map<String, String> response = new HashMap<>();
        try {
            Libro libro = libroService.buscarLibro(id);
            libroService.eilimnaLibro(libro);
            response.put("message", "libro eliminado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "el libro no se pudo eliminar!");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
