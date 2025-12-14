package com.ignacio.fs3_lab_examenes.repository;

import com.ignacio.fs3_lab_examenes.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
