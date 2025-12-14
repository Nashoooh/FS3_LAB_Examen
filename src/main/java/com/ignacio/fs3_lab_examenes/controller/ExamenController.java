package com.ignacio.fs3_lab_examenes.controller;

import com.ignacio.fs3_lab_examenes.model.Examen;
import com.ignacio.fs3_lab_examenes.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
    @Autowired
    private ExamenService service;

    @GetMapping
    public List<Examen> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Examen no encontrado con id: " + id));
    }

    @PostMapping
    public Examen create(@RequestBody Examen examen) {
        return service.save(examen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> update(@PathVariable Long id, @RequestBody Examen examen) {
        return service.findById(id).map(e -> {
            examen.setId(id);
            return ResponseEntity.ok(service.save(examen));
        }).orElseThrow(() -> new ResourceNotFoundException("Examen no encontrado con id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) throw new ResourceNotFoundException("Examen no encontrado con id: " + id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
