package com.ignacio.fs3_lab_examenes.service;

import com.ignacio.fs3_lab_examenes.model.Examen;
import com.ignacio.fs3_lab_examenes.model.ExamenDetalleDTO;
import com.ignacio.fs3_lab_examenes.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ExamenDetalleDTO> findAllDetalles() {
        List<Object[]> results = repo.findAllDetallesNativo();
        return results.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ExamenDetalleDTO> findByUsuarioIdDetalles(Long usuarioId) {
        List<Object[]> results = repo.findByUsuarioIdDetallesNativo(usuarioId);
        return results.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<ExamenDetalleDTO> findByIdDetalles(Long id) {
        List<Object[]> results = repo.findByIdDetallesNativo(id);
        if (results.isEmpty()) return Optional.empty();
        return Optional.of(mapToDTO(results.get(0)));
    }

    private ExamenDetalleDTO mapToDTO(Object[] row) {
        ExamenDetalleDTO dto = new ExamenDetalleDTO();
        dto.setId(((Number) row[0]).longValue());
        dto.setFechaExamen(((java.sql.Date) row[1]).toLocalDate());
        dto.setUsuarioId(((Number) row[2]).longValue());
        dto.setResultado((String) row[3]);
        dto.setLaboratorioId(((Number) row[4]).longValue());
        dto.setLaboratorioDireccion((String) row[5]);
        dto.setAnalisisId(((Number) row[6]).longValue());
        dto.setAnalisisNombre((String) row[7]);
        dto.setAnalisisDescripcion((String) row[8]);
        return dto;
    }
}
