package com.ignacio.fs3_lab_examenes.repository;

import com.ignacio.fs3_lab_examenes.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
    @Query(value = "SELECT ex.id, ex.fecha_examen, ex.usuario_id, ex.resultado, " +
                   "lab.id as laboratorio_id, lab.direccion, " +
                   "anl.id as analisis_id, anl.nombre, anl.descripcion " +
                   "FROM examenes ex " +
                   "JOIN laboratorios lab ON ex.laboratorio_id = lab.id " +
                   "JOIN analisis anl ON ex.analisis_id = anl.id",
           nativeQuery = true)
    List<Object[]> findAllDetallesNativo();

    @Query(value = "SELECT ex.id, ex.fecha_examen, ex.usuario_id, ex.resultado, " +
                   "lab.id as laboratorio_id, lab.direccion, " +
                   "anl.id as analisis_id, anl.nombre, anl.descripcion " +
                   "FROM examenes ex " +
                   "JOIN laboratorios lab ON ex.laboratorio_id = lab.id " +
                   "JOIN analisis anl ON ex.analisis_id = anl.id " +
                   "WHERE ex.usuario_id = :usuarioId",
           nativeQuery = true)
    List<Object[]> findByUsuarioIdDetallesNativo(@Param("usuarioId") Long usuarioId);

    @Query(value = "SELECT ex.id, ex.fecha_examen, ex.usuario_id, ex.resultado, " +
                   "lab.id as laboratorio_id, lab.direccion, " +
                   "anl.id as analisis_id, anl.nombre, anl.descripcion " +
                   "FROM examenes ex " +
                   "JOIN laboratorios lab ON ex.laboratorio_id = lab.id " +
                   "JOIN analisis anl ON ex.analisis_id = anl.id " +
                   "WHERE ex.id = :id",
           nativeQuery = true)
    List<Object[]> findByIdDetallesNativo(@Param("id") Long id);
}
