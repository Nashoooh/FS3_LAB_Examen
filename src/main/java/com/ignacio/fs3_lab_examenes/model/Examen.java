package com.ignacio.fs3_lab_examenes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "examenes")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "laboratorio_id", nullable = false)
    private Long laboratorioId;

    @Column(name = "analisis_id", nullable = false)
    private Long analisisId;

    @Column(name = "fecha_examen", nullable = false)
    private LocalDate fechaExamen;

    @Column(nullable = false)
    private String resultado;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getLaboratorioId() { return laboratorioId; }
    public void setLaboratorioId(Long laboratorioId) { this.laboratorioId = laboratorioId; }
    public Long getAnalisisId() { return analisisId; }
    public void setAnalisisId(Long analisisId) { this.analisisId = analisisId; }
    public LocalDate getFechaExamen() { return fechaExamen; }
    public void setFechaExamen(LocalDate fechaExamen) { this.fechaExamen = fechaExamen; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
