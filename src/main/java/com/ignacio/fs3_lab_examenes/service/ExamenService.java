package com.ignacio.fs3_lab_examenes.service;

import com.ignacio.fs3_lab_examenes.model.Examen;
import com.ignacio.fs3_lab_examenes.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {
    @Autowired
    private ExamenRepository repo;

    public List<Examen> findAll() {
        return repo.findAll();
    }

    public Optional<Examen> findById(Long id) {
        return repo.findById(id);
    }

    public Examen save(Examen examen) {
        return repo.save(examen);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
