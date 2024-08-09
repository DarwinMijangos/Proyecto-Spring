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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darwinmijangos.webapp.biblioteca.model.Prestamo;
import com.darwinmijangos.webapp.biblioteca.service.PrestamoService;

@Controller
@RestController
@RequestMapping(name = "")
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;
 
    @GetMapping("/prestamos")
    public ResponseEntity<List<Prestamo>> listarPrestamos(){
        try {
            return ResponseEntity.ok(prestamoService.listarPrestamos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @GetMapping("/prestamo")
    public ResponseEntity<Prestamo> buscarPrestamo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(prestamoService.buscarPrestamoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @PostMapping("/prestamo")
    public ResponseEntity<Map<String, String>> agregarPrestamo(@RequestBody Prestamo prestamo){
        Map<String, String> response = new HashMap<>();
        try {
            prestamoService.guardarPrestamo(prestamo);
            response.put("Message", "Prestamo creado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "hubo un error al crear el prestamo!");
            return ResponseEntity.badRequest().body(null);
        }
    }
   
    @PutMapping("/prestamo")
    public ResponseEntity<Map<String, String>> editarPrestamo(@RequestBody Long id, @RequestBody Prestamo prestamoNuevo){
        Map<String, String> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamo.setCliente(prestamoNuevo.getCliente());
            prestamo.setEmpleado(prestamoNuevo.getEmpleado());
            prestamo.setFechaDeDevolucion(prestamoNuevo.getFechaDeDevolucion());
            prestamo.setFechaDePrestamo(prestamoNuevo.getFechaDePrestamo());
            prestamo.setLibros(prestamoNuevo.getLibros());
            prestamo.setVigencia(prestamoNuevo.getVigencia());
            prestamoService.guardarPrestamo(prestamo);
            response.put("Message", "El prestamo se ha modificado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "el prestamo no se pudo editar!");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @DeleteMapping("/prestamo")
    public ResponseEntity<Map<String, String>> eliminarPrestamo(@RequestBody Long id){
        Map<String, String> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamoService.eliminarPrestamo(prestamo);
            response.put("message", "prestamo eliminado con exito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "el prestamo no se pudo eliminar!");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
